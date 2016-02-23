package com.ttnd.linksharing

import com.ttnd.linksharing.CO.UserCo

class UserController {

    def index() {

        render "user dashboard"
        render "\n"
        render "${session.user.userName}"
    }


    def register(UserCo co) {

        if (!session.user) {
            log.error("user is registered...")
            flash.message = "please register first!"
            User user = new User(firstName: co.firstName, lastName: co.lastName, email: co.email, password: co.password)
            if (user.validate()) {
                flash.message = "${user.firstName} registered successfully"

            } else {
                flash.message = "validations failed"

            }
        } else
            render("already registered")

    }
}
