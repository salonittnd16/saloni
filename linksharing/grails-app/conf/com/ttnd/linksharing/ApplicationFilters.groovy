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
        logincheck(controller: 'login', invert:true){
            before = {
                if (!session.user) {
                    println("=================================================")
                    redirect(controller: 'login', action: 'index')

                }


            }
            after = { Map model ->


            }
            afterView = { Exception e ->

            }


        }

    }

}


