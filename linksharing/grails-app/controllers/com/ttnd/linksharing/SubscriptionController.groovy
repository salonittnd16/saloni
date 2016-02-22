package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness

class SubscriptionController {

    def index() { render("subscription section") }

    def save(int id) {
        Topic topic = Topic.get(id)
        Subscription subscription = Subscription subscription = new Subscription(user: session.user, topic: topic, seriousness: Seriousness.VERY_SERIOUS)
        if(subscription.save(flush:true))
            render "success"
        else
            render "couldn't save subscription"
    }

    def update() {

    }

    def delete(int id) {
        Subscription subscription = Subscription.get(id)
        if (subscription) {

            subscription.delete(flush: true)
            render "successfully deleted subscription"
        } else {
            render("subscription not found")
        }

    }
}
