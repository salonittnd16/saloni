package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility

class Topic {


    String name;
    User createdBy;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility

    static constraints = {

        name nullable: false, blank: false, unique: 'createdBy'
        createdBy nullable: false


    }
    static hasMany = [resources: Resource, subscriptions: Subscription]



    def afterInsert()
    {
                Topic.withNewSession{

                    Subscription subscription = new Subscription(user: this.createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS).save()

                    log.info("${this.createdBy} subscribed to ${this}")
                }


    }
    String toString()
    {
        name
    }

}



