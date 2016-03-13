package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import grails.converters.JSON

class TopicController {

    def index() {
        render "topic show"


    }

    def show(ResourceSearchCo co) {
        Topic topic = Topic.read(co.topicId)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC) {
                List<Resource> posts = Resource.findAllByTopic(topic)
                render(view: '/topic/topicshow', model: [subscribedUsers: topic.subscribedUsers, topic: topic, posts: posts])

            } else {
                Subscription subscription = Subscription.findByUserAndTopic(topic.createdBy, topic)
                if (subscription)
                    render "subscription exists"
                else
                    redirect(controller: 'login', action: 'index')
            }

        } else {
            redirect(controller: 'login', action: 'index')
            flash.message = "topic doesn't exist"
        }


    }

    def save(String topicName, String visibility) {
        Topic topic = new Topic(name: "${topicName} new", createdBy: session.user, visibility: Visibility.convert(visibility))
        Map result = [:]
        if (topic.save(flush: true, failOnError: true)) {
            result.message = "topic saved successfully"
        } else {
            result.error = "topic save unsuccessful"
        }
        render(result as JSON)
        redirect(controller: 'login', action: 'index')
    }

    def delete(Long topicId) {
        Topic topic = Topic.get(topicId)
        Map result = [:]
        if (session.user == topic.createdBy || session.user.admin) {
            topic.delete(flush: true)
            result.message = "topic deleted successfully"
        } else {
            result.error = "topic cannot be deleted"
        }
        render(result as JSON)
    }
    def invite(Long id,String email){
       Topic topic=Topic.get(id)
        if(!topic){
            flash.error="topic not found"
        }



    }
}
