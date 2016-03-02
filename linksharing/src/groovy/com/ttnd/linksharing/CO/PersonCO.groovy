package com.ttnd.linksharing.CO

import grails.validation.Validateable

/**
 * Created by saloni on 2/3/16.
 */
@Validateable
class PersonCO {

    String name
    int age

    static constraints={
        name nullable: false
        age nullable:false
    }
}
