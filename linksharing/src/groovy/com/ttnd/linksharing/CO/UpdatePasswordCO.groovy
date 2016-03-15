package com.ttnd.linksharing.CO

import com.ttnd.linksharing.User

/**
 * Created by saloni on 15/3/16.
 */
class UpdatePasswordCO {
    String oldPassword
    String password
    Long id

    User getUser() {
        return User.get(id)

    }
    static constraints = {
        importFrom User
        oldPassword nullable: false, validator: { val, obj ->
            if (val) {
                if (obj.password != val) {
                    return "passwords.don't.match"
                }
            }
        }
    }
}