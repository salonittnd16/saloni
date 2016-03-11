package com.ttnd.linksharing

import grails.plugin.cache.CustomCacheKeyGenerator
import grails.util.Holders
import org.springframework.beans.factory.annotation.Autowired

class DemoController {

    def demoService
    def myBean
    def myBeanUsingConstructor
    @Autowired
    CustomBean customBean
    def mailService

    // injection by type. first will look by type and then by name.if there is only one custombean in
//    resources.groovy then it will take it(even if name is different) but if there are multiple beans
// in resources then it searches by name and if matching is not found then exception is thrown.

    def index() {
//        render demoService.sum(10,20)
        render "mail sent"
        mailService.sendMail {
            to "surbhi.dhawan@tothenew.com"
//            from "staging.mycroft@gmail.com"
//            cc "marge@g2one.com", "ed@g2one.com"
//            bcc "joe@g2one.com"
            subject "Hello Surbhi"
            body 'this is some text'
        }
    }

//        render myBean.properties
//        render myBeanUsingConstructor.properties
//        def c= Holders.applicationContext.getBean('myBean')
//        render c.properties
//    }


}
