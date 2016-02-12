package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ResourceRating)
class ResourceRatingSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }
    void "test resource rating"()
    {
        ResourceRating resourceRating=new ResourceRating(user:user,resource:res,score:sc)

        when:
        Boolean result=resourceRating.validate()

        then:
        result==valid

        where:
        user       | res                | sc | valid
        new User() | new LinkResource() | 2  | true
        null       | new LinkResource() | 2  | false
        new User() | null               | 3  | false
        new User() | new LinkResource() | 0  | false
        new User() | new LinkResource() | 6  | false
        null       | null               | 4  | false


    }
}
