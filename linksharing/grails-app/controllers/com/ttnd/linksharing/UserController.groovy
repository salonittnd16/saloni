package com.ttnd.linksharing

class UserController {

    def index() {

        render "user dashboard"
        render "\n"
        render "${session.user.userName}"
    }


    def register() {

        if(!session.user)
        {
            log.error("user is not able to register")
            flash.message="unregistered user"
        }
        else
        render("already registered")

    }
}
