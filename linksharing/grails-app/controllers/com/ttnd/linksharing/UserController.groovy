package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.CO.TopicSearchCo
import com.ttnd.linksharing.CO.UserCo

class UserController {
    def assetResourceLocator
    def topicService
    def subscriptionService
    def resourceService

    def index() {

        List<Subscription> subscriptions = Subscription.findAllByUser(session.user)
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(session.user, [sort: 'dateCreated', order: 'desc', max: 2])
        render view: 'dashboard', model: [listOfTopics: session.user.subscribedTopics, readingItems: readingItems, subscriptions: subscriptions]
    }


    def register(UserCo co) {

        if (!session.user) {
            flash.message = "please register first!"
            User user = new User(firstName: co.firstName, lastName: co.lastName, userName: co.userName,
                    email: co.email, password: co.password, confirmPassword: co.confirmPassword)
            if (!params.pic.empty)
                user.photo = co.pic
            if (user.save(flush: true)) {
                flash.message = "${user.firstName} registered successfully"
                render(flash.message)
            } else {
                List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])
                render(view: "/login/home", model: [user: user, recentshares: recentShares])
            }
        } else {
            render("already registered")
        }

    }

    def search() {
        render view: 'search'
    }

    def post(Long postId) {
        Resource resource = Resource.get(postId)
        if (resource.canViewBy(postId)) {
            render(view: 'post', model: [post: resource])
        } else {
            render "access denied"
        }
    }

    def profile(ResourceSearchCo resourceSearchCo) {
        resourceSearchCo.max = resourceSearchCo.max ?: 5
        resourceSearchCo.offset = resourceSearchCo.offset ?: 0
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: resourceSearchCo.id,
                visibility: resourceSearchCo.visibility, max: params.max, offset: params.offset)
        List<Resource> postsCreated = resourceService.search(resourceSearchCo)
        List<Topic> topics = topicService.search(topicSearchCo)
        int topicCount = topics.size()
        List<Topic> subscribedTopics = subscriptionService.search(topicSearchCo)
        render(view: "/user/userProfile", model: [subscribedTopics: subscribedTopics,
                                                  resourceSearchCo: resourceSearchCo,
                                                  postsCreated: postsCreated,
                                                  listOfTopics: topics, topicCount: topicCount])


    }

    def changePassword(String pwd, String changePwd) {
        println(pwd)
        println(changePwd)
        if (pwd.equals(changePwd)) {
            render "password updated successfully"
        } else {
            render "entered passwords donot match"
        }


    }

    def image(Long id) {
        User user = User.findById(id)
        byte[] image
        if (user.photo) {
            image = user.photo
        } else {
            image = assetResourceLocator.findAssetForURI('userdefault.jpeg').byteArray
        }
        OutputStream out = response.getOutputStream()
        out.write(image)
        out.flush()
        out.close()

    }

    def edit(ResourceSearchCo resourceSearchCo) {
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: resourceSearchCo.id, visibility: resourceSearchCo.visibility, max: params.max, offset: params.offset)
        List<Topic> topics = topicService.search(topicSearchCo)
        render(view: '/user/myProfile' ,model: [listOfTopics: topics])
    }

}
