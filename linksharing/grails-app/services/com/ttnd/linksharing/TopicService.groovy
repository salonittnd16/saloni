package com.ttnd.linksharing

import com.ttnd.linksharing.CO.TopicSearchCo
import grails.transaction.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }

    List<Topic> search(TopicSearchCo topicSearchCo) {
        Topic.findAllByCreatedByAndVisibility(topicSearchCo.getUser(), topicSearchCo.visibility,[max:topicSearchCo.max,
        offset: topicSearchCo.offset])
    }
}
