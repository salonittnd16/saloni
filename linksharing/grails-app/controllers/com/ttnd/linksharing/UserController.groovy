package com.ttnd.linksharing

import DTO.EmailDTO
import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.CO.TopicSearchCo
import com.ttnd.linksharing.CO.UpdatePasswordCO
import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.CO.UserSearchCo
import com.ttnd.linksharing.VO.UserVO

class UserController {
    int check = 0
    def assetResourceLocator
    def topicService
    def subscriptionService
    def resourceService
    def emailService

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
            } else {
                flash.error = "register unsuccessfull!!!!"
                List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])
                render(view: "/login/home", model: [user: user, recentshares: recentShares])
            }
        } else {
            flash.error = "already registered!!!!"
        }
        redirect(url: request.getHeader("referer"))

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
        User user = User.findById(resourceSearchCo.id)
        Integer totalCount = Resource.countByCreatedBy(user)
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: resourceSearchCo.id,
                visibility: resourceSearchCo.visibility, max: resourceSearchCo.max, offset: resourceSearchCo.offset)
        List<Resource> postsCreated = resourceService.search(resourceSearchCo)
        List<Topic> topics = topicService.search(topicSearchCo)
        List<Topic> subscribedTopics = subscriptionService.search(topicSearchCo)
        if (!request.xhr) {
            render(view: "/user/userProfile", model: [subscribedTopics: subscribedTopics,
                                                      resourceSearchCo: resourceSearchCo,
                                                      postsCreated    : postsCreated,
                                                      listOfTopics    : topics, totalCount: totalCount])
            check++
        } else {
            render(template: "/user/resourceAjax", model: [postsCreated: postsCreated, resourceSearchCo: resourceSearchCo, totalCount: totalCount])

        }


    }

    def updatePassword(UpdatePasswordCO co) {
        println("******************************${co.id}")
        User.executeUpdate("update User set password='${co.password}' where id='${session.user.id}'")
        render "password updated successfully"

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

    def forgotPassword(String email) {
        User user = User.findByEmail(email)
        if (user && user.active) {
            String newPassword = Utility.getRandomPassword()
            user.password = newPassword
            EmailDTO emailDTO = new EmailDTO(to: [email], subject: "Link to generate New Password",
                    view: '/email/_password', model: [newPassword: newPassword])
            emailService.sendMail(emailDTO)
            redirect(controller: 'login', action: 'index')

        }
    }

    def edit(ResourceSearchCo resourceSearchCo) {
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: resourceSearchCo.id, visibility: resourceSearchCo.visibility, max: params.max, offset: params.offset)
        List<Topic> topics = topicService.search(topicSearchCo)
        render(view: '/user/myProfile', model: [listOfTopics: topics, id: session.user.id])

    }

    def list(UserSearchCo userSearchCO) {
        List<UserVO> userVOList = []
        if (session.user?.admin) {
            List users = User.search(userSearchCO).list([sort: userSearchCO.sort, order: userSearchCO.order]).each { user ->
                userVOList.add(new UserVO(id: user.id, userName: user.userName, email: user.email, firstName: user.firstName,
                        lastName: user.lastName, active: user.active))
            }
            render(view: 'list', model: [users: userVOList, userSearchCO: userSearchCO, totalCount: users.totalCount])
        } else {

            redirect(controller: 'user', action: 'index')
        }
    }

    def updateProfile(UserCo userCo) {
        if (User.executeUpdate("update User set firstName='${userCo.firstName}' ,lastName='${userCo.lastName}'," +
                "userName='${userCo.userName}', photo='${userCo.pic}' where id='${session.user.id}' ")) {
            flash.message = "profile edit successfully !!!!"

        } else
            flash.error = "profile edit unsuccessfull !!!!!!"


    }

    def toggleActive(Long id) {
        if (session.user?.admin) {
            User user = User.get(id)
            if (user.active) {
                user.active = false
            } else {
                user.active = true
            }
            if (user.save(flush: true)) {
                flash.message = "toggled successfully"
            } else {
                flash.message = "toggle unsuccessful"
            }
            redirect(action: 'list')
        }
    }

}
