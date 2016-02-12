package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }

    void "test reading item"() {
        given:
        ReadingItem readingItem = new ReadingItem(user: user, resource: res, isRead: true)

        when:
        Boolean result = readingItem.validate()

        then:
        result == valid

        where:
        user       | res                    | valid
        new User() | new DocumentResource() | true
        null       | new LinkResource()     | false
        new User() | null                   | false
        null       | null                   | false


    }

}
