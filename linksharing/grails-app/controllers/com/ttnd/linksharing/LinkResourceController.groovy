package com.ttnd.linksharing

class LinkResourceController extends ResourceController {

    def index() {
        render "upload link resources"
    }

    def save(LinkResource linkResource) {
        linkResource.createdBy = session.user
        if (linkResource.save(flush: true)) {
            addToReadingItems(linkResource)
            render view: '/user/dashboard'
            flash.message = "saved resource"
        }
        else {
            render(linkResource.errors)
        }


    }
}
