package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import grails.transaction.Transactional

@Transactional
class ResourceService {

    def serviceMethod() {

    }

    List<Resource> search(ResourceSearchCo resourceSearchCo) {
        User user = resourceSearchCo.getUser()
        Resource.searchCreatedResources(user).list([max: resourceSearchCo.max, offset: resourceSearchCo.offset])

    }

    ReadingItem addToReadingItems(Resource resource, Long id) {
        Topic topic = resource.topic
        ReadingItem readingItem
        List<User> users = topic.getSubscribedUsers()
        User user = User.get(id)
        users.each {

            if (user == it) {
                readingItem = new ReadingItem(resource: resource, user: it, isRead: true)

            } else {
                readingItem = new ReadingItem(resource: resource, user: it, isRead: false)
            }
            it.readingItems.add(readingItem)
        }
        readingItem
    }

}