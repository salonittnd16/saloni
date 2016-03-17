package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import com.ttnd.linksharing.Enum.Seriousness

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Subscription)
class SubscriptionSpec extends Specification {


    void "test subscription"() {

        expect:
        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: seriousness)


        when:
        Boolean result = subscription.validate()
        then:
        result == isValid
        where:
        description        | user       | topic       | seriousness         || isValid
        "All valid fields" | new User() | new Topic() | Seriousness.SERIOUS || true
        "Null topic"       | new User() | null        | Seriousness.SERIOUS || false
        "All valid fields" | null       | new Topic() | Seriousness.SERIOUS || false


    }

}
