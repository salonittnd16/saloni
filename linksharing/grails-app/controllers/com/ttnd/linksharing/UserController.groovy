package com.ttnd.linksharing

import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.VO.TopicVo

class UserController {

    def index() {

        List<TopicVo> topicVoList =Topic.getTrendingTopics()
        render view: 'dashboard', model: [listOfTopics: session.user.subscribedTopics,trendingTopics:topicVoList]
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
}
