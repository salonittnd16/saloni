package com.ttnd.linksharing


class LoginController {

    def index() {
        if (session.user) {
            forward(controller: 'user', action: 'index')
        } else {

            List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])
            render view: 'home', model: [recentshares: recentShares]
        }
    }


    def login(String username, String password) {
        log.info "${username}, ${password}"
        User user = User.findByUserNameAndPassword(username, password)
        if (user) {
            if (user.active) {
                session.user = user
                redirect(controller: "user", action: "index")
                //render view: '/user/dashboard'
            } else
                flash.message = "User is not active"

        } else {
            flash.message = "User account not found"
            render flash.message
        }
    }

    def validateUserName() {
        Integer count = User.countByUserName(params.userName)
        return count ? false : true

    }
    def validateEmail() {
        Integer count = User.countByEmail(params.userName)
        return count ? false : true

    }

    def forgotPassword() {
        render(template: "/login/forgotPassword")

    }

    def logout()

    {
        session.invalidate()
        redirect action: 'index'
    }
}






