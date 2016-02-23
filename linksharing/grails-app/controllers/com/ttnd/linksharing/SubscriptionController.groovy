package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness

class SubscriptionController {

    def index() { render("subscription section") }

    def save(long id) {
        Topic topic = Topic.get(id)
        Subscription subscription  = new Subscription(user: session.user, topic: topic, seriousness: Seriousness.SERIOUS)
        if(subscription.save(flush:true))
            render "success"
        else
            render "couldn't save subscription"
    }

    def update(long id,String seriousness) {
        Subscription subscription=Subscription.get(id)
        if(subscription)
        {
            subscription.seriousness=seriousness as Seriousness
            if(subscription.save(flush: true))
                render("successfully updated")
            else
            render "couldn't save ${subscription.id}"
        }
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
