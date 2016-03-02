package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.VO.RatingInfoVo
import com.ttnd.linksharing.VO.TopicVo

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




    static List<Resource> topResources(){
        List result = ResourceRating.showTopPosts()
        List ids = []
        result.each {
            ids.add(it[0])
        }
        List<Resource> resources = Resource.getAll(ids)
        resources
    }

    def show(){
        List<TopicVo> topicVoList =Topic.getTrendingTopics()


    }


    String toString() {
        return "Topic: ${this.topic.name} ... ${this.description}"
    }

}