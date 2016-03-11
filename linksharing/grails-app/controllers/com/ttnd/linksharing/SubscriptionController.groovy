package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness
import grails.converters.JSON

class SubscriptionController {

    def index() { render("subscription section") }

    def save(Long id) {
        Topic topic = Topic.get(id)
        Subscription subscription = new Subscription(user: session.user, topic: topic, seriousness: Seriousness.SERIOUS)
        if (subscription.save(flush: true))
            render([message: "subscribed successfully"] as JSON)
        else
            render([error: "subscribed unsuccessfully"] as JSON)
    }

    def update(Long id, String seriousness) {
        Map result = [:]
        Subscription subscription = Subscription.get(id)
        if (subscription) {
            subscription.seriousness = seriousness as Seriousness
            if (subscription.save(flush: true))
                result.message="subscription updated successfully"
            else
                result.error= "subscription updation unsuccessful"
        }
        render(result as JSON)
    }

    def delete(Long id) {
        Map result = [:]
        Subscription subscription = Subscription.get(id)
        if (subscription && subscription.topic.createdBy!=session.user) {

            subscription.delete(flush: true)
            result.message = "subscription deleted successfully"
        } else {
            result.error = "subscription delete unsuccessful"
        }
        render(result as JSON)
    }
}
