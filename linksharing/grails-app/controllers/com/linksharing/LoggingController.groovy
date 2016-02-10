package com.linksharing

class LoggingController {

    def index() {


        log.error("error page")
        log.fatal("fatal error occured")


    }
}
