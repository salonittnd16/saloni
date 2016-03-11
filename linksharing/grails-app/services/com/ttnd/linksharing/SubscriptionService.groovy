package com.ttnd.linksharing

import com.ttnd.linksharing.CO.TopicSearchCo
import grails.transaction.Transactional

@Transactional
class SubscriptionService {

    def serviceMethod() {

    }

    List<Topic> search(TopicSearchCo topicSearchCo) {
        topicSearchCo.getUser().getSubscribedTopics()
    }
}
