package com.ttnd.linksharing

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class ResourceRating {
    Integer score;

    static constraints = {

        score min: 1, max: 5,nullable: false
        resource unique: 'user', nullable: false
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