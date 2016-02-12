package com.ttnd.linksharing

class ResourceRating {
   // Resource resource;
    //User user;
    Integer score;

    static constraints = {

        score min: 1, max: 5
        resource unique: 'user', nullable: false
        score nullable: false
        user nullable: false

    }
    static belongsTo = [user: User, resource: Resource]
}
