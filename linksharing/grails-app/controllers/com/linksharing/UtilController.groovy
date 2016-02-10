package com.linksharing

class UtilController {

    def index() {
        render(grailsApplication.config.grails.testvalue)

    }
}
