package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Visibility
import grails.test.mixin.TestFor
import org.omg.CORBA.PUBLIC_MEMBER
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
class TopicSpec extends Specification {




    void "test all topic validations"() {

        setup:
        Topic topic = new Topic(name: name, createdBy: author, visibility: visibility);


        when:
        Boolean result = topic.validate()

        then:
        result == valid

        where:
        name     | author     | visibility         | valid
        "grails" | new User() | Visibility.PUBLIC  | true
        ""       | new User() | Visibility.PRIVATE | false
        null     | new User() | Visibility.PUBLIC  | false
        "mean"   | null       | Visibility.PRIVATE | false

    }
    def "tostring"()
    {
        given:
        User user =new User()
        Topic topic = new Topic(name: "grails", createdBy: user, visiblity: Visibility.PUBLIC )
        when:
        String expected=topic.toString()

        then:
        expected=="topic: grails"
    }




}
