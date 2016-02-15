package com.linksharing

import groovy.util.logging.Log4j

@Log4j
class LoggingController {

    def index() {


        log.error("error page")
        log.fatal("fatal error occured")


    }
}
