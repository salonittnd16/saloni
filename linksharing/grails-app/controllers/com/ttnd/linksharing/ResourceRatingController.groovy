package com.ttnd.linksharing

class ResourceRatingController {

    def index() {
        render "ratings section"
    }

    def saveRatings(Long resourceId, int rate) {
        Resource resource = Resource.get(resourceId)
        if (ResourceRating.executeUpdate("update ResourceRating as r set r.score=:score where r.resource.id=:resource", [score: rate, resource: resource.id])) {
            flash.message="rating saved successfully"
        } else {
            render "not saved"
        }
        redirect(url: request.getHeader("referer"))
    }
}


