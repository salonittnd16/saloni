package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.VO.RatingInfoVo
import com.ttnd.linksharing.VO.TopicVo
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
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
            if (co.topicId && co.q) {
                'topic' {
                    eq('id', co.topicId)
                    eq('visibility', co.visibility)

                }
            }
            ilike('description',"%${co.q}%")

        }
        searchCreatedResources{ User user->
            eq('createdBy',user)
        }

    }

    static hasMany = [resourceRatings: ResourceRating, readingItems: ReadingItem]
    static belongsTo = [topic: Topic]

    RatingInfoVo getRatingInfo() {
        List result = ResourceRating.createCriteria().get {
            'resource' {
                eq('id', this.id)
            }
            projections {
                sum('score')
                avg('score')
                count('score')


            }
        }
        RatingInfoVo ratingInfoVo = new RatingInfoVo(totalVotes: result[0], averageScore: result[1], totalScore: result[2])
        ratingInfoVo
    }

    void setRatingInfo() {


    }

    void deleteFile(){
        log.info("this will be implemented in linkResource")

    }


    static List<Resource> topResources() {
        List result = ResourceRating.showTopPosts()
        List ids = []
        result.each {
            ids.add(it[0])
        }
        List<Resource> resources = Resource.getAll(ids)
        resources
    }

//    def show() {
//        List<TopicVo> topicVoList = Topic.getTrendingTopics()
//
//
//    }


    Boolean canViewBy(Long id) {
        Resource resource = Resource.get(id)
        if (resource.topic.canViewedBy(topic.id)) {
            return true
        }
    }


    String toString() {
        return "Topic: ${this.topic.name} ... ${this.description}"
    }
    static List usersWithUnreadResources() {
        return ReadingItem.createCriteria().listDistinct {
            projections {
                property('user')
            }
            eq('isRead', false)
        }
    }

}