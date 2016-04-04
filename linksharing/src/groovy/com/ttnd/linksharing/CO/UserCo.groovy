package com.ttnd.linksharing.CO

import grails.validation.Validateable

/**
 * Created by saloni on 23/2/16.
 */
@Validateable
class UserCo {
    String firstName
    String lastName
    String email
    String password
    String userName
    String confirmPassword
    Byte[] pic



}
