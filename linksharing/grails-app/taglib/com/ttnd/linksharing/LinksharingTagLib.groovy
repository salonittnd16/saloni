package com.ttnd.linksharing

import com.ttnd.linksharing.VO.TopicVo

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
        Resource resource = Resource.read(attrs.resource)
        if (resource instanceof LinkResource) {
            out << " <a href=\"#\" class=\"inline\" style=\"float:right;padding: 2px\"><u>View Full Site</u></a>"

        } else if (resource instanceof DocumentResource) {
            out << "<a href=\"#\" class=\"inline\" style=\"float:right;padding: 2px\"><u>Download</u></a>"
        }

    }


    def deleteResource = { attrs ->
        String link = ""
        Closure c = {
            "Delete"
        }
        User user = session.user
        if (user.canDeleteResource(attrs.resourceId as Long)) {
            link = g.link(controller: "resource", action: "delete", params: [postId: attrs.resourceId], c())
        }
        out << link
    }


    def showSusbcribe = { attrs ->
        if (session.user && attrs.topicId) {


        }

    }


    def showUnsuscribe = { attrs, body ->
        User user = session.user
        user.isSusbsribed(attrs.topicId)
        out << body()


    }

    def subscriptionsShow = { attrs, body ->
        Subscription subscription = Subscription.get(attrs.subscriptionId as Long)
        User user = session.user
        if (subscription.topic.createdBy == user || user.admin) {
            out << render(template: '/user/mysubscribedtopics', model: [subscriptionId: attrs.subscriptionId])
        } else {
            out << render(template: '/user/mysuscribedNotCreated')

        }
    }


    def subscriptionCount = { attrs ->
        Topic topic = Topic.get(attrs.topicId)
        Integer count = topic.subscriptions.size()
        out << "<small class=\"col-xs-12\">${count}</small>"
    }

    def postCount = { attrs ->
        Topic topic = Topic.get(attrs.topicId)
        Integer count = topic.resources.size()
        out << "<small class=\"col-xs-12\">${count}</small>"
    }
    def topicCount = { attrs ->
        User user = session.user
        Integer count = user.topics.size()


    }


}