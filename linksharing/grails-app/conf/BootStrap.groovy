import com.ttnd.linksharing.DocumentResource
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.LinkResource
import com.ttnd.linksharing.ReadingItem
import com.ttnd.linksharing.Resource
import com.ttnd.linksharing.Subscription
import com.ttnd.linksharing.Topic
import com.ttnd.linksharing.User
import com.ttnd.linksharing.ResourceRating
import com.ttnd.linksharing.Constants.Constant
import org.xhtmlrenderer.css.parser.property.PrimitivePropertyBuilders;


class BootStrap {

    def grailsApplication
    def init = { servletContext ->
        List<User> users = createUsers()
        List<Topic> topics = createTopics(users)
        List<Resource> resources = createResources(topics)
        List<Subscription> subscriptions = createSubscriptions(users, topics)
        List<ReadingItem> readingItems = createReadingItems(users, topics)
        List<ResourceRating> resourceRatings=createResourceRating(users,resources)

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


    List<Resource> createResources(List<Topic> topics) {
        List<Resource> resources = []

        if (DocumentResource.count == 0 && LinkResource.count == 0) {

            topics.each { topic ->

                DocumentResource documentResource1 = new DocumentResource(filePath: "a/b/c", description: "description${topic.name}",
                        createdBy: topic.createdBy,
                        topic: topic)
                DocumentResource documentResource2 = new DocumentResource(filePath: "a/b/c", description: "description${topic.name}",
                        createdBy: topic.createdBy,
                        topic: topic)

                LinkResource linkResource1 = new LinkResource(url: "http://www.blogjava.net/BlueSUN", description: "description${topic.name}",
                        createdBy: topic.createdBy, topic: topic)
                LinkResource linkResource2 = new LinkResource(url: "http://www.blogjava.net/BlueSUN", description: "description${topic.name}",
                        createdBy: topic.createdBy, topic: topic)

                if (documentResource1.save()) {
                    resources.add(documentResource1)
                    topic.addToResources(documentResource1)
                    topic.createdBy.addToResources(documentResource1)
                    log.info "---------${documentResource1.description} added for $topic--------\n"
                } else
                    log.error("error creating ${documentResource1.description} for user $topic")

                if (documentResource2.save()) {
                    resources.add(documentResource2)
                    topic.addToResources(documentResource1)
                    topic.createdBy.addToResources(documentResource1)
                    log.info "---------${documentResource2.description} added for $topic--------\n"
                } else
                    log.error("error creating ${documentResource2.description} for user $topic")

                if (linkResource1.save()) {
                    resources.add(linkResource1)
                    topic.addToResources(linkResource1)
                    topic.createdBy.addToResources(linkResource1)
                    log.info "---------${linkResource1.description} added for $topic--------\n"
                } else
                    log.error("error creating ${linkResource1.description} for user $topic")

                if (linkResource2.save()) {
                    resources.add(linkResource2)
                    topic.addToResources(linkResource2)
                    topic.createdBy.addToResources(linkResource2)
                    log.info "---------${linkResource2.description} added for $topic--------\n"
                } else
                    log.error("error creating ${linkResource2.description} for user $topic")


            }

        } else {
            log.info("DocumentResource and LinkResource Tables not empty")
            Resource.list()

        }
        resources

    }

    List<Subscription> createSubscriptions(List<User> users, List<Topic> topics) {
        List<Subscription> subscriptions = []
        users.each { User user ->
            topics.each {
                Topic topic ->
                    if (topic.createdBy != user) {

                        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Seriousness.VERY_SERIOUS)
                        if (subscription.save(flush: true)) {

                            subscriptions.add(subscription)
                            log.info("${user} subscribed to ${topic}")
                        } else
                            log.error("error creating ${subscription} for user $user")
                    }
            }
        }


        subscriptions

    }

    List<ReadingItem> createReadingItems(List<User> users, List<Topic> topics) {

        List<ReadingItem> readingItems = []

        users.each
                {
                    user ->
                        topics.each
                                {
                                    topic ->
                                        if (Subscription.findByUserAndTopic(user, topic)) {

                                            topic.resources.each
                                                    {
                                                        resource ->
                                                            if (resource.createdBy != user && !user.readingItems?.contains(resource)) {
                                                                ReadingItem readingItem = new ReadingItem(user: user, resource: resource, isRead: false)



                                                                if (readingItem.save()) {
                                                                    readingItems.add(readingItem)
                                                                    user.addToReadingItems(readingItem)
                                                                    log.info "${readingItem} saved successfully"
                                                                } else
                                                                    log.error "unable to save reading item: ${readingItem.errors.allErrors}"
                                                            }

                                                    }

                                        }



                                }

                }

        readingItems
    }



    List<ResourceRating> createResourceRating(List<User> users,List<ReadingItem> readingItemsnew) {
        List<ResourceRating> resourceRatings = []
        users.each { user ->
            readingItemsnew = ReadingItem.findAllByUser(user)
            readingItemsnew.each { readingItems1 ->
                if (!readingItems1.isRead) {
                    ResourceRating resourceRating = new ResourceRating(user: readingItems1.user,resource: readingItems1.resource,
                            score: 4)

                    if (resourceRating.save()) {

                        resourceRatings.add(resourceRating)
                        user.addToResourceRatings(resourceRating)
                        log.info "${resourceRating} saved successfully"
                    } else
                        log.error "Error saving ${resourceRating.errors.allErrors}"
                }
            }

        }

        resourceRatings

    }



    def destroy = {


    }
}
