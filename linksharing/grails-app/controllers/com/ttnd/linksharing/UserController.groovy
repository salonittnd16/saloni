package com.ttnd.linksharing

import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.VO.TopicVo

class UserController {

    def index() {
        List<Subscription> subscriptions=Subscription.findAllByUser(session.user)
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(session.user, [max: 2])
        render view: 'dashboard', model: [listOfTopics: session.user.subscribedTopics, readingItems: readingItems,subscriptions:subscriptions]
    }


    def register(UserCo co) {

        if (!session.user) {
            flash.message = "please register first!"
            User user = new User(firstName: co.firstName, lastName: co.lastName, userName: co.userName, email: co.email, password: co.password, confirmPassword: co.confirmPassword)
            if (user.save(flush: true)) {

                flash.message = "${user.firstName} registered successfully"
                render(flash.message)
            } else {
                flash.message = "validations failed"
            }
        } else
            render("already registered")
        redirect(controller: 'login', action: 'index')

    }

    def search() {
        render view: 'search'
    }

    def post(Long postId) {
        Resource resource = Resource.get(postId)
        if (resource.canViewBy(postId)) {
            render(view: 'post', model: [post: resource])
        }
        else {
            render "access denied"
        }
    }

}
