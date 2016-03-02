package com.ttnd.linksharing

class LinkResourceController {

    def index() {
        render "upload link resources"
    }

    def save(LinkResource linkResource) {
        linkResource.createdBy = session.user
        if (linkResource.save(flush: true)) {
            render view: '/user/dashboard'
            flash.message = "saved resource"
        }


    }
}
