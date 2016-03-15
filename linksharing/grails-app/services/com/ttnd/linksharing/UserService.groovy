package com.ttnd.linksharing

import grails.transaction.Transactional

@Transactional
class UserService {
    def emailService

    def serviceMethod() {

    }
    def sendUnreadItemsEmail(){
        getUserWithUnreadItems().each { user ->
            emailService.sendUnreadResourcesEmail(user, getUnreadResources(user))
        }

    }
    List<User> getUserWithUnreadItems(){
        return Resource.usersWithUnreadResources()
    }

    List<Resource> getUnreadResources(User user) {
        List<ReadingItem> readingItemList=ReadingItem.findAllByUserAndIsRead(user,false)
        List<Resource> resources=readingItemList.collect {
            it.resource
        }
        resources

    }
}
