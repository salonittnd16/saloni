package com.ttnd.linksharing


class LoginController {

    def index() {
        if (session.user) {
            forward(controller: 'user', action: 'index')
        } else {
            println "inside else    "
            render "user is not logged in"
        }
    }


    def login(String username, String password) {
        User user = User.findByUserNameAndPassword(username, password)
        if (user) {
            if (user.active) {
                session.user = user
                redirect(action: 'index')
            } else
                flash.message = "User is not active"

        } else {
            flash.message = "User account not found"
            render flash.message
        }
    }

    def logout()

    {
        session.invalidate()
        redirect(action: 'index')
    }
}






























