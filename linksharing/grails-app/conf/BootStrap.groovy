import com.ttnd.linksharing.DocumentResource
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.LinkResource
import com.ttnd.linksharing.ReadingItem
import com.ttnd.linksharing.Resource
import com.ttnd.linksharing.Subscription
import com.ttnd.linksharing.Topic
import com.ttnd.linksharing.User
import com.ttnd.linksharing.Constants.Constant;


class BootStrap {

    def grailsApplication
    def init = { servletContext ->
        List<User> users = createUsers()
        List<Topic> topics = createTopics(users)
        List<Resource> resources = createResources(topics)
        List<Subscription> subscriptions = createSubscriptions(users,topics)
        List<ReadingItem> readingItems=createReadingItems(resources)

        //println(grailsApplication.config.grails.testvalue)


    }

    List<User> createUsers() {

        if (User.count == 0) {
            List<User> users = []
            User user1 = new User(firstName: "saloni", lastName: "sharma", email: "saloni@gmail.com", password: Constant.DEFAULT_PASSWORD, userName: "sal",
                    admin: true, active: true);
            User user2 = new User(firstName: "shalika", lastName: "singhal", email: "shalika@gmail.com", password: Constant.DEFAULT_PASSWORD, userName: "shal",
                    admin: false, active: true);
            try {

                if (user1.save(flush: true, failOnError: true)) {
                    users.add(user1)
                    log.info "User ${user1} saved successfully"
                }
            } catch (Exception e) {
                log.error "Error saving user : ${user1.errors.allErrors}"

            }
            try {
                if (user2.save(flush: true, failOnError: true)) {
                    users.add(user2)
                    log.info "User ${user2} saved successfully"
                }
            } catch (Exception e) {
                log.error "Error saving user : ${user2.errors.allErrors}"

            }
            users
        } else {
            User.list()
        }
    }

    List<Topic> createTopics(List<User> users) {
        if (Topic.count == 0) {
            List<Topic> topics = []
            users.each { User user ->
                (1..5).each {
                    Topic topic = new Topic(name: "Topic${it}", createdBy: user, visibility: Visibility.PUBLIC);
                    topics.add(topic)
                    if (user.addToTopics(topic).save(flush: true))
                        log.info "---------${topic.name} added for $user--------\n"
                    else
                        log.error("error creating ${topic.name} for user $user")
                }
            }
            topics
        } else {
            log.info("Topic table not empty")
            Topic.list()
        }
    }


    List<Resource> createResources(topics) {
        List<Resource> resources = []

        if (DocumentResource.count == 0 && LinkResource.count == 0) {

            topics.each {

                DocumentResource documentResource1 = new DocumentResource(filePath: "a/b/c", description: "description${it.name}",
                        createdBy: it.createdBy,
                        topic: it)
                DocumentResource documentResource2 = new DocumentResource(filePath: "a/b/c", description: "description${it.name}",
                        createdBy: it.createdBy,
                        topic: it)

                LinkResource linkResource1 = new LinkResource(url: "http://", description: "description${it.name}",
                        createdBy: it.createdBy, topic: it)
                LinkResource linkResource2 = new LinkResource(url: "http://", description: "description${it.name}",
                        createdBy: it.createdBy, topic: it)

                if (documentResource1.save()) {
                    resources.add(documentResource1)
                    log.info "---------${documentResource1.description} added for $it--------\n"
                } else
                    log.error("error creating ${documentResource1.description} for user $it")

                if (documentResource2.save()) {
                    resources.add(documentResource2)
                    log.info "---------${documentResource2.description} added for $it--------\n"
                } else
                    log.error("error creating ${documentResource2.description} for user $it")

                if (linkResource1.save()) {
                    resources.add(linkResource1)
                    log.info "---------${linkResource1.description} added for $it--------\n"
                } else
                    log.error("error creating ${linkResource1.description} for user $it")

                if (linkResource2.save()) {
                    resources.add(linkResource2)
                    log.info "---------${linkResource2.description} added for $it--------\n"
                } else
                    log.error("error creating ${linkResource2.description} for user $it")


            }

        } else {
            log.info("DocumentResource and LinkResource Tables not empty")
            Resource.list()

        }
        resources


    }

    List<Subscription> createSubscriptions(List<User> users,List<Topic> topics) {
        List<Subscription> subscriptions = []
            users.each { User user ->
                topics.each {
                    Topic topic ->
                        if (topic.createdBy != user) {

                            Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Seriousness.VERY_SERIOUS)
                            if (subscription.save(flush: true)) {

                                subscriptions.add(subscription)
                                log.info("${user} subscribed to ${topic}")
                            }
                            else
                                log.error("error creating ${subscription} for user $user")
                        }
                }
            }


        subscriptions

    }

    List<ReadingItem> createReadingItems(List<Resource> resources)
    {



    }


    def destroy = {


    }
}
