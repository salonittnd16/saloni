package com.ttnd.linksharing

import spock.util.mop.Use

class ReadingItem {
    //Resource resource;
    //User user;
    Boolean isRead;
    Date dateCreated;
    Date lastUpdated;


    static constraints = {
        resource unique:'user',nullable:false
        user nullable:false
    }
    static belongsTo = [user:User,resource:Resource]
}
