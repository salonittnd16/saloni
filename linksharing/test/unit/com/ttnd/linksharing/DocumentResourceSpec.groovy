package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {



    def "test document resource validations"() {
        setup:
        DocumentResource documentResource = new DocumentResource(filePath: fpath, description: "collections in groovy", createdBy: new User(), topic: new Topic())

        when:
        Boolean result = documentResource.validate()

        then:
        result == valid

        where:
        fpath           | valid
        "abc"           | true
        "/home/saloni/" | true
        null            | false
        ""              | false


    }

}
