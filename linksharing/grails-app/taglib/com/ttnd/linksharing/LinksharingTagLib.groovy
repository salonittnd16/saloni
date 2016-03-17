package com.ttnd.linksharing

import com.ttnd.linksharing.VO.TopicVo

//import org.apache.commons.collections.Closure

class LinksharingTagLib {
    static namespace = "ls"
    def checkIsRead = { attrs, body ->
        if (session.user) {
            if (attrs.isRead)
                out << body()
        }

    }

    def checkIsUnRead = { attrs, body ->
        if (session.user) {
            if (!attrs.isRead) {
                out << body()

            }
        }

    }
    def showTopPosts = {

        List<Resource> topPosts = Resource.topResources()
        out << render(template: '/login/topposts', model: [topPosts: topPosts])


    }
    def showTrendingTopics = {
        if (session.user) {
            List<TopicVo> topicVoList = Topic.getTrendingTopics()
            out << render(template: '/user/trendingtopics', model: [trendingTopics: topicVoList])


        }
    }
    def checkResourceType = { attrs ->
        String link = ""
        Resource resource = Resource.read(attrs.resource)
        if (resource instanceof LinkResource) {
            out << " <a href=\"${resource.url}\" class=\"inline\" target=\"_blank\" style=\"float:right;\"><u>View Full Site</u></a>"

        } else if (resource instanceof DocumentResource) {
            link = g.link(controller: "documentResource", action: "download", params: [id: attrs.resource], {
                "Download"
            })
            out << link
        }

    }


    def deleteResource = { attrs ->
        String link = ""
        Closure c = {
            "Delete"
        }
        User user = session.user
        if (user) {
            if (user.canDeleteResource(attrs.resourceId as Long)) {
                link = g.link(controller: "resource", action: "delete", params: [postId: attrs.resourceId], c())
            }
        }
        out << link
    }


    def showUnsuscribe = { attrs, body ->
        User user = session.user
        if (user.isSusbsribed(attrs.topicId as Long)) {
            Topic topic = Topic.get(attrs.topicId)
            Subscription subscription = Subscription.findByUserAndTopic(user, topic)
            out << g.link(onclick: "unsubscribe(${subscription.id})", name: "unsuscribe", controller: "subscription", action: "delete", params: [id: subscription.id as Long], {
                "Unsubscribe"
            })
        } else {
            out << g.link(onclick: "subscribe(${attrs.topicId})", name: "suscribe", controller: "subscription", action: "save", params: [id: attrs.topicId as Long], {
                "Subscribe"
            })
        }
    }

    def canUpdateTopic = { attrs, body ->
        Topic topic = Topic.get(attrs.topicId)
        User user = session.user
        String parent = attrs.parent
        if (topic.createdBy == user) {
            out << render(template: '/user/mysubscribedtopics', model: [topicId: attrs.topicId, parent: parent])
        } else {
            out << render(template: '/user/mysuscribedNotCreated', model: [topicName: topic.name])

        }
    }

    def showSeriousness = { attrs, body ->
        User user = session.user
        if (user) {
            Subscription subscription = user.getSubscription(attrs.topicId as Long)
            if (subscription) {
                out << g.select(class: "seriousness", topicId: attrs.topicId, name: 'seriousness',
                        from: com.ttnd.linksharing.Enum.Seriousness.values(), value: subscription.seriousness)
            } else {
                flash.error = "user not subscribed to topic"
            }

        } else {
            flash.error = "Please Login"
        }

    }

    def showVisibility = { attrs ->
        User user = session.user
        if (user) {
            Topic topic = Topic.get(attrs.topicId as Long)
            if (topic) {
                out << g.select(class: "visibility", name: 'visibility', topicName: topic.name,
                        from: com.ttnd.linksharing.Enum.Visibility.values(), value: topic.visibility)
                println(topic.name)
            } else {
                flash.error = "topic not found"
            }
        } else {
            flash.error = "Please login first"
        }
    }


    def subscriptionCount = { attrs ->
        Topic topic = Topic.get(attrs.topicId)
        Integer count = topic.subscriptions.size()
        out << "<small class=\"col-xs-12\">${count}</small>"
    }

    def subscriptionCountByUser = {
        if (session.user) {
            Integer subscriptioncount = Subscription.findAllByUser(session.user).size()
            out << "<small class=\"col-xs-12\">${subscriptioncount}</small>"

        }

    }

    def postCount = { attrs ->
        Topic topic = Topic.get(attrs.topicId)
        Integer count = topic.resources.size()
        out << "<small class=\"col-xs-12\">${count}</small>"
    }
    def topicCount = { attrs ->
        User user = session.user
        Integer count = Topic.findAllByCreatedBy(user).size()
        out << "<small class=\"col-xs-12\">${count}</small>"

    }

    def userImage = { attrs, body ->
        User user = User.get(attrs.id)
        if (user.photo) {
            out << "<img src=\"/user/image/${attrs.id}\" width=\"64\" height\"64\"/> "
        } else
            out << "<img src=\"/user/image/${attrs.id}\" width=\"64\" height\"64\"/>"

    }


}