package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.VO.TopicVo

class Topic {


    String name;
    User createdBy;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility

    static mapping = {
        sort "name"
    }

    static constraints = {

        name nullable: false, blank: false, unique: 'createdBy'
        createdBy nullable: false


    }
    static hasMany = [resources: Resource, subscriptions: Subscription]

    static getTrendingTopics() {
        List<TopicVo> topicVoList = Topic.createCriteria().list() {

            projections {
                groupProperty('id')
                count('resources', 'resourceCount')
            }
            maxResults 5
            max('resources')
            eq('visibility', Visibility.PUBLIC)
            // order("resourceCount", "desc")
            order("name", "desc")

        }
        topicVoList

    }


    def afterInsert() {
        Topic.withNewSession {

            Subscription subscription = new Subscription(user: this.createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS).save(flush: true)

            log.info("${this.createdBy} subscribed to ${this}")
        }


    }

    String toString() {
        return "topic: ${name}"
    }

}



