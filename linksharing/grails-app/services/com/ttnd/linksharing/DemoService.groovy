package com.ttnd.linksharing

import grails.transaction.Transactional

@Transactional
class DemoService {


    Integer sum(int a, int b) {

        throw IOException
        a + b

    }



}
