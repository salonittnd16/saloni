package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }




    void "test all topic validations"() {

        setup:
        User user=new User();
        //User user = new User(firstName:"saloni", lastName: "sharma", email: "saloni@gmail.com", password: "hello", userName: "sa",
             //   admin: true, active: true);
        user.metaClass.validate={ return true}
        Topic topic = new Topic(name:name,createdBy:user);


        when:
        Boolean result = topic.validate()

        then:
        result==valid

        where:
        name | valid
        "grails" | true

    }


}
