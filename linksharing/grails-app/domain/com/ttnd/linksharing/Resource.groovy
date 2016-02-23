package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.VO.RatingInfoVo

abstract class Resource {

    String description;
    User createdBy;
    //Topic topic;
    Date DateCreated;
    Date lastUpdated;

    static mapping = { description(type: 'text') }

    static transients = ['ratingInfo']
    static constraints = {
    }
    static namedQueries = {
        search { ResourceSearchCo co ->
            if (co.topicId) {
                'topic' {
                    eq('id', co.topicId)
                    eq('visibility', co.visibility)
                }
            }

        }

    }

    static hasMany = [resourceRatings: ResourceRating, readingItems: ReadingItem]
    static belongsTo = [topic: Topic]

    RatingInfoVo getRatingInfo() {
        return RatingInfoVo
    }

    void setRatingInfo() {


    }


    static informationOfRatings() {
        List result = ResourceRating.createCriteria().list() {
            'resource' {
                eq('id', 1L)
            }
            projections {
                sum('score')
                avg('score')
                count('score')


            }
        }
        result
    }

    String toString() {
        return "Topic: ${this.topic.name} ... ${this.description}"
    }
}