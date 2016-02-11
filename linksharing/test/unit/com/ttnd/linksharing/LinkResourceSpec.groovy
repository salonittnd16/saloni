package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LinkResource)
class LinkResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test link resource validations"() {
        setup:
        LinkResource linkResource = new LinkResource(url: url)

        when:
        Boolean result = linkResource.validate()

        then:
        result == valid

        where:
        url   | valid
        "abc" | false

    }

}
