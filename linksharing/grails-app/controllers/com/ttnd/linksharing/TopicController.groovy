package com.ttnd.linksharing


import com.ttnd.linksharing.Enum.Visibility

class TopicController {

    def index() { render "topic controller"}

    def show(int id) {
        Topic topic = Topic.read(id)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC)
            {  render "success"

            }

            else {
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

    def save(Topic topic,String visibility)
    {
        if(topic) {
            topic.createdBy = session.user
            topic.visibility = Enum.valueOf(Visibility.class, visibility)
            if (topic.save(flush: true)) {
                flash.message = "topic saved successfully"
                render "success"
            }
        } else {
            render "No User....."
        }
    }
}
