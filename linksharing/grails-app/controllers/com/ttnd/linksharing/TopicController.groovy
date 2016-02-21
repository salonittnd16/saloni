package com.ttnd.linksharing


import com.ttnd.linksharing.Enum.Visibility

class TopicController {

    def index() {}

    def show(int id) {
        Topic topic = Topic.findById(id)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC)
                render "success"
            else {
                Subscription subscription = Subscription.findByUserAndTopic(topic.createdBy, topic)
                if (subscription)
                    render "success"
                else
                    redirect(controller: 'Login', action: 'index')

            }

        } else {
            redirect(controller: 'Login', action: 'index')
            flash.message = "topic doesn't exist"
        }


    }
}
