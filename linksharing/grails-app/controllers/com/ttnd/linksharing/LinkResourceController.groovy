package com.ttnd.linksharing

class LinkResourceController extends ResourceController {

    def index() {
        render "upload link resources"
    }

    def save(LinkResource linkResource) {
        linkResource.createdBy = session.user
        User user = session.user
        user.refresh()
        if (linkResource.save(flush: true)) {
            ReadingItem readingItem = addToReadingItems(linkResource)
            ResourceRating resourceRating = new ResourceRating(user: readingItem.user, resource: readingItem.resource, score: 4)
            resourceRating.save(flush: true)
            user.addToResourceRatings(resourceRating)
            redirect(controller: 'user',action: 'index')
        } else {
            render(linkResource.errors)
        }


    }
}
