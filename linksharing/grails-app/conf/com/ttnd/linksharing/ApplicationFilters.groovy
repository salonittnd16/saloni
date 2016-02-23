package com.ttnd.linksharing

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                log.info("controller name : ${controllerName} and action : ${actionName}")

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
        sessioncheck() {}
        logincheck(controller: 'login', invert: true) {
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


