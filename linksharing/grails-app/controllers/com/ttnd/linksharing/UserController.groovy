package com.ttnd.linksharing

class UserController {

    def index() {

        render "user dashboard"
        render session.username
    }


    def register() {

        if(!session.user)
        {
            log.error("user is not able to register")
            flash.message="unregise"
        }

    }
}
