package com.ttnd.linksharing

import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.VO.TopicVo

class UserController {
    def assetResourceLocator

    def index() {
        List<Subscription> subscriptions = Subscription.findAllByUser(session.user)
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(session.user, [sort:'dateCreated',order:'desc',max: 2])
        render view: 'dashboard', model: [listOfTopics: session.user.subscribedTopics, readingItems: readingItems, subscriptions: subscriptions]
    }


    def register(UserCo co) {

        if (!session.user) {
            flash.message = "please register first!"
            User user = new User(firstName: co.firstName, lastName: co.lastName, userName: co.userName, email: co.email, password: co.password, confirmPassword: co.confirmPassword)
            if (user.save(flush: true)) {

                flash.message = "${user.firstName} registered successfully"
                render(flash.message)
            } else {

                render(template: "/login/register", model: [user: user])
            }
        } else
            render("already registered")

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

}
