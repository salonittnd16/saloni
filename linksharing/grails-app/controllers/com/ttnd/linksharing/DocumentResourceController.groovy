package com.ttnd.linksharing

class DocumentResourceController {

    def index() { render "document resource section" }


    def save(DocumentResource documentResource) {
        documentResource.createdBy = session.user
        if (documentResource.save(flush: true)) {
            render(view: '/user/dashboard')
            flash.message = "document resource saved"
        }

    }
}
