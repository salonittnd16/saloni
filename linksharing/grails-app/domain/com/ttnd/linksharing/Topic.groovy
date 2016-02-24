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

    static hasMany = [resources: Resource, subscriptions: Subscription]
    static mapping = {
        sort "name"
    }

    static constraints = {

        name nullable: false, blank: false, unique: 'createdBy'
        createdBy nullable: false


    }


    static getTrendingTopics() {
        List topicVoList = Resource.createCriteria().list() {

            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.name')
                property('t.visibility')
                property('t.createdBy')
                createAlias(count('id'),'resourceCount')
                count('resourceCount')
            }
            max('resourceCount')

            maxResults 5

            //eq('visibility', Visibility.PUBLIC)
            // order("resourceCount", "desc")
            order("t.name", "desc")

        }
        println "${topicVoList}"
        List<TopicVo> topicVoList1 = []
        topicVoList.each {
            topicVoList1.add(new TopicVo(id: it[0], name: it[1], visibility: it[2], createdBy: it[3], count: it[4]))
        }

        return topicVoList1
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



