package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Subscription {
    Seriousness seriousness;
    Date dateCreated;
    Date lastUpdated;


    static constraints = {
        user nullable: false
        topic nullable: false, unique: 'user'


    }
    static belongsTo = [user: User, topic: Topic]

}

