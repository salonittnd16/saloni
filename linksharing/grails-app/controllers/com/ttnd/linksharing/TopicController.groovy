package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility

class TopicController {

    def index() {
        User user = session.user
        Topic topic = Topic.findByCreatedBy(user)
        render(view: '/topic/topicshow', model: [subscribedUsers: topic.subscribedUsers,topic:topic])
    }

    def show(ResourceSearchCo co) {
        Topic topic = Topic.read(co.topicId)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC) {
                redirect(view: 'index')

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

    def save(String name, String visibility) {
        Topic topic = new Topic(name: name, createdBy: session.user, visibility: Visibility.convert(visibility))

        if (topic.save(flush: true, failOnError: true)) {
            flash.message = " topic saved successfully"
            render flash.message
            render view: '/user/dashboard'
        } else {
            log.error(" Could not save Topic ${topic.name}")
            flash.message = "Topic ${topic.name} not saved"
            render flash.message


        }


    }
}
