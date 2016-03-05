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
    static transients = ['subscribedUsers']

    static constraints = {

        name nullable: false, blank: false, unique: 'createdBy'
        createdBy nullable: false


    }

    static List<TopicVo> getTrendingTopics() {
        List result = Resource.createCriteria().list([max: 2]) {

            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.name')
                property('t.visibility')
                count('id')
                property('t.createdBy')
            }
//order("r.id", "desc")
            eq('t.visibility', Visibility.PUBLIC)
            order("t.name", "desc")
            maxResults 5
        }
        println("=========================${result}")
        List<TopicVo> topicVo = []
        result.each {
            topicVo.add(new TopicVo(id: it[0], name: it[1], visibility: it[2], count: it[3], createdBy: it[4]))
        }
        topicVo


    }

//    static List<TopicVo> getTrendingTopics() {
//        List topicVoList = Resource.createCriteria().list() {
//
//            projections {
//                createAlias('topic', 't')
//                groupProperty('t.id')
//                property('t.name')
//                property('t.visibility')
//                property('t.createdBy')
//                //createAlias(count('id'), 'resourceCount')
//                count('id')
//            }
//            max('resourceCount')
//
//            maxResults 5
//
//            eq('visibility', Visibility.PUBLIC)
//           // order("resourceCount", "desc")
//            order("t.name", "desc")
//
//        }
//        println "${topicVoList}"
//        List<TopicVo> topicVoList1 = []
//        topicVoList.each {
//            topicVoList1.add(new TopicVo(id: it[0], name: it[1], visibility: it[2], createdBy: it[3], count: it[4]))
//        }
//
//        return topicVoList1
//    }


    def afterInsert() {
        Topic.withNewSession {

            Subscription subscription = new Subscription(user: this.createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS).save(flush: true)

            log.info("${this.createdBy} subscribed to ${this}")
        }


    }

    List<User> getSubscribedUsers() {

        List<User> users = Subscription.createCriteria().list() {

            projections {
                property('user')

            }
            eq('topic.id', this.id)

        }
        users
    }

    Boolean isPublic(Long id) {
        Topic topic = Topic.read(id)
        if (topic.visibility == Visibility.PUBLIC)
            true
        else
            false
    }

    Boolean canViewedBy(Long Userid) {
        User user =User.get(Userid)
        Topic topic = Topic.get(this.id)
        if (isPublic(id) || user.admin || topic.subscribedUsers.contains(user))
            return true
         else
            false


    }

    String toString() {
        return name
    }

}



