package com.ttnd.linksharing

import com.ttnd.linksharing.CO.UserSearchCo
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class User {

    String firstName;
    String lastName;
    String userName;
    String password;
    String email;
    String confirmPassword
    Byte[] photo;
    Boolean admin;
    Boolean active = true;
    Date dateCreated;
    Date lastUpdated;

    static mapping = {
        photo(sqlType:  'longblob')
        sort id: "desc"
    }

    static transients = ['name', 'confirmPassword', 'subscribedTopics']


    static constraints = {
        email unique: true, email: true, blank: false, nullable: false
        password nullable: false, blank: false, minSize: 5
        firstName nullable: false, blank: false
        lastName nullable: false, blank: false
        photo nullable: true
        admin nullable: true
        active nullable: true
        confirmPassword(bindable: true, nullable: true, blank: true, validator: { val, obj ->
            if (val) {
                if (obj.password != val) {
                    return "passwords.don't.match"
                }
            }
        })


    }
    static namedQueries = {
        search { UserSearchCo userSearchCO ->
            eq('admin', false)
            if (userSearchCO.active != null) {
                eq("active", userSearchCO.active)
            }

            if (userSearchCO.q) {
                or {
                    ilike("firstName", "%${userSearchCO.q}%")
                    ilike("lastName", "%${userSearchCO.q}%")
                    ilike("email", "%${userSearchCO.q}%")
                    ilike("userName", "%${userSearchCO.q}%")

                }
            }
        }
    }
    static hasMany = [topics: Topic, subscriptions: Subscription, resources: Resource, readingItems: ReadingItem, resourceRatings: ResourceRating]

    String getName() {
        [firstName, lastName].findAll { it }.join(' ')

    }


    List<Topic> getSubscribedTopics() {

        List<Topic> topics = Subscription.createCriteria().list() {

            projections {
                property('topic')

            }
            eq('user.id', this.id)


        }
        topics
    }

    int getScore(int score) {


    }

    Boolean canDeleteResource(Long resourceId) {
        Resource resource = Resource.get(resourceId)
        if (this.admin || this == resource.createdBy) {
            return true
        } else {
            return false

        }
    }

    Boolean isSusbsribed(Long topicId) {
        Topic topic = Topic.get(topicId)
        Integer susbcribedUsersCount = Subscription.createCriteria().count {

            eq('user', this)
            eq('topic', topic)

        }

        if (susbcribedUsersCount) {
            true
        } else {
            false
        }

    }

    Boolean equals(User user) {
        this.id==user.id
    }

    Subscription getSubscription(Long topicId) {
        Topic topic = Topic.get(topicId)
        Subscription subscription = Subscription.findByUserAndTopic(this, topic)
        subscription

    }


    String toString() {
        firstName

    }

}
