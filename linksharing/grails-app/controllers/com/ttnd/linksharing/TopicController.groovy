package com.ttnd.linksharing

import DTO.EmailDTO
import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.VO.TopicVo
import grails.converters.JSON

class TopicController {
    def emailService

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
//        redirect(controller: 'login', action: 'index')
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



    def invite(Long id, String email) {
        Topic topic = Topic.get(id)
        if (topic) {
            TopicVo topicVO = new TopicVo(id: topic.id, name: topic.name, visibility: topic.visibility,
                    createdBy: topic.createdBy)
            EmailDTO emailDTO = new EmailDTO(to: [email], subject: "Invitations for topic from linksharing",
                    view: '/email/_invite', model: [currentUser: session.user, topic: topicVO])
            emailService.sendMail(emailDTO)
            flash.message = "Successfully sent invitation"
        } else {
            flash.error = "Can't send invitation"
        }
        redirect(controller: "login", action:"index")
    }
    def join(Long id){
        Topic topic=Topic.get(id)
        Subscription subscription = new Subscription(user: session.user, topic: topic, seriousness: Seriousness.VERY_SERIOUS)
        if(subscription.save(flush: true)){
            flash.message="subscribed to topic"
        }
        else {
            flash.error="not subscribed successfully through invitation"
        }
        redirect(controller: "login", action: 'index')
    }

    def update(Long id,String topicName){
        Topic topic=Topic.get(id)
        if(topic){
            topic.name=topicName
            if(topic.save(flush: true)){
                render([success: true,topicName:topic.name] as JSON)
            }else {
                render([error: true,message:"error in updating"] as JSON)
            }
        }else{
            render([error: true,message:"topic not found"] as JSON)

        }
    }
}
