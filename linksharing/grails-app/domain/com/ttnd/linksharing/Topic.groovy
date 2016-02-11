package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Visibility

class Topic {


    String name;
    User createdBy;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility

    static constraints = {

        name nullable: false, blank: false, unique:'createdBy'
        createdBy nullable: false


    }
    static hasMany = [resources:Resource,subscriptions:Subscription]

}
