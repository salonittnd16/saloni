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



    static showTopPosts(){
        List resourceRatings=ResourceRating.createCriteria ( ).list ( ) {

            projections {
                createAlias('resource','r')
                groupProperty('r.id')
                count('score', 'res')
            }
            order('res', 'desc')
            maxResults 5

        }
        resourceRatings
    }

}