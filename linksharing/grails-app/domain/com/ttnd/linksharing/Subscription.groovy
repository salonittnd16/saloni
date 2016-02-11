package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness
import spock.util.mop.Use

class Subscription {

    User user;
    Topic topic;
    Seriousness seriousness;
    Date dateCreated;
    Date lastUpdated;


    static constraints = {
        user nullable:false
        topic nullable:false,unique:'user'


    }
    static belongsTo = [user:User,topic:Topic]

}