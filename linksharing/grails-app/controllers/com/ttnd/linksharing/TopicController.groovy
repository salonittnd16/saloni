package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility

class TopicController {

    def index() { render "topic controller" }

    def show(long id, ResourceSearchCo co) {
        Topic topic = Topic.read(id)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC) {
                render "success"

            } else {
                Subscription subscription = Subscription.findByUserAndTopic(topic.createdBy, topic)
                if (subscription)
                    render "success"
                else
                    redirect(controller: 'login', action: 'index')

            }

        } else {
            redirect(controller: 'Login', action: 'index')
            flash.message = "topic doesn't exist"
        }


    }

    def save(String name, String seriousness) {
        Topic topic = new Topic(name: name, createdBy: session.user, visibility: Visibility.convert(seriousness))

        if (topic.save(flush: true, failOnError: true)) {
            flash.message = "Success "
            render flash.message
        } else {
            log.error(" Could not save Topic ${topic.name}")
            flash.message = "Topic ${topic.name} not saved"
            render flash.message


        }


    }
}
