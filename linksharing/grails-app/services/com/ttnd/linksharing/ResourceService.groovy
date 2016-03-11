package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import grails.transaction.Transactional

@Transactional
class ResourceService {

    def serviceMethod() {

    }

    List<Resource> search(ResourceSearchCo resourceSearchCo) {
        User user = resourceSearchCo.getUser()
        Resource.searchCreatedResources(user).list([max:resourceSearchCo.max,offset:resourceSearchCo.offset])

    }
}