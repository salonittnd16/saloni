package com.ttnd.linksharing

class ResourceRatingController {

    def index() {
        render "ratings section"
    }

    def saveRatings(Long resourceId, int rate) {
        Resource resource = Resource.get(resourceId)
        if (ResourceRating.executeUpdate("update ResourceRating as r set r.score=:score where r.resource.id=:resource", [score: rate, resource: resource.id])) {
            render("rating saved successfully")
// redirect(controller: 'resource',action: 'show',id:resourceId)
        } else {
            render "not saved"
        }

    }
}


