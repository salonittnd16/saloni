package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.VO.RatingInfoVo
import com.ttnd.linksharing.VO.TopicVo

class ResourceController {

    def index() {
        render "resources section"

    }

    def delete(long id) {
        try {
            Resource resource = Resource.load(id)
            render "resource deleted : ${resource.id}"
            resource.delete(flush: true)

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

    def show() {
        List resultratings = Resource.informationOfRatings()
        RatingInfoVo vo = resultratings.collect { List res ->
            return new RatingInfoVo(totalScore: res[0], averageScore: res[1], totalVotes: res[2])
        }
        render(vo)

    }
    def showtopics(){
        List<TopicVo> topicVoList=Topic.getTrendingTopics()
        render topicVoList


    }


}