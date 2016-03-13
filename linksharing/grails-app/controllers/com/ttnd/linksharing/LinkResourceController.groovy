package com.ttnd.linksharing

class LinkResourceController extends ResourceController {
    def resourceService

    def index() {
        render "upload link resources"
    }

    def save(LinkResource linkResource, Long id) {
        linkResource.createdBy = session.user
        User user = session.user
        Long sessionId = session.user.id
        user.refresh()
        if (linkResource.save(flush: true)) {
            ReadingItem readingItem = resourceService.addToReadingItems(linkResource, sessionId)
            ResourceRating resourceRating = new ResourceRating(user: readingItem.user, resource: readingItem.resource, score: 4)
            resourceRating.save(flush: true)
            user.addToResourceRatings(resourceRating)
            redirect(controller: 'user', action: 'index')
        } else {
            render(linkResource.errors)
        }


    }
}
