package com.ttnd.linksharing

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                log.info "User Controller"
                log.info "Login Controller"
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
        sessioncheck() {}
        logincheck(controller: 'Login', invert: true) {
            before = {


            }
            after = { Map model ->
                if (!session.user){}
                //   redirect(controller: 'Login', action: 'index')


            }
            afterView = { Exception e ->

            }


        }

    }

}


