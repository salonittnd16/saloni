package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.VO.RatingInfoVo
import com.ttnd.linksharing.VO.TopicVo

class ResourceController {

    def index() {
        render "resources section"

    }

    def delete(long postId) {
        try {
            Resource resource = Resource.load(postId)
            resource.delete(flush: true)
            resource.deleteFile()
            redirect(controller: "user", action: "index")

        }
        catch (Exception e) {
            render(e.message)
        }

    }

    def search(ResourceSearchCo co) {
        if (co.q) {
            co.visibility = Visibility.PUBLIC

        }
        List<Resource> resources = Resource.search(co).list()
        render resources
    }

    def show(Long id) {

        Resource resource = Resource.findById(id)
        if (resource.canViewBy(id)) {
            RatingInfoVo ratingInfoVo = resource.ratingInfo
            render "----------total votes : $ratingInfoVo.totalVotes----average score: $ratingInfoVo.averageScore------total score: $ratingInfoVo.totalScore"
            render(view: '/user/post')
        }

    }

    def showtopics() {
        List<TopicVo> topicVoList = Topic.getTrendingTopics()
        render topicVoList
    }

    def topPosts() {
        List result = ResourceRating.showTopPosts()
        List ids = []
        result.each {
            ids.add(it[0])
        }
        List<Resource> resources = Resource.getAll(ids)
        render resources


    }

    ReadingItem addToReadingItems(Resource resource) {
        Topic topic = resource.topic
        ReadingItem readingItem
        List<User> users = topic.getSubscribedUsers()
        users.each {

            if (session.user == it) {
                readingItem = new ReadingItem(resource: resource, user: it, isRead: true)

            } else {
                readingItem = new ReadingItem(resource: resource, user: it, isRead: false)
            }
            it.readingItems.add(readingItem)
        }
        readingItem
    }


}