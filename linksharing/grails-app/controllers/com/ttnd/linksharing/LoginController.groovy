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
                flash.message = "welcome ${session.user.name}"
            } else
                flash.message = "User is not active"

        } else {
            redirect(action: 'index')
            flash.message = "User account not found"
        }
    }

    def validateUserName() {
        Integer count = User.countByUserName(params.userName)
        render count ? false : true

    }

    def validateEmail() {
        Integer count = User.countByEmail(params.email)
        render count ? false : true

    }

    def logout()

    {
        session.invalidate()
        redirect action: 'index'
    }
}






