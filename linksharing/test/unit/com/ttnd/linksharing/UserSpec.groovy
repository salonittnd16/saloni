package com.ttnd.linksharing

import grails.test.mixin.TestFor
import jdk.nashorn.internal.ir.annotations.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll("Executing #sno")
    void "test user validations"() {

        setup:
        User user = new User(firstName: fname, lastName: lname, email: email, password: password, userName: uname,
                admin: admin, active: active);

        when:
        Boolean result = user.validate()

        then:
        result == valid
        where:
        sno | fname        | lname    | email              | password  | admin | active | uname     | valid
        1   | ""           | "hello"  | "a@b.com"          | "test123" | false | false  | ""        | false
        1   | "Saloni"     | "sharma" | "saloni@gmail.com" | "test123" | false | true   | "sal30"   | true
        1   | "Shalika123" | "hello"  | "shalika"          | "test123" | true  | true   | "shal123" | false
    }

    @Unroll
    @IgnoreRest
    def "get user full name"() {
        setup:
        User user = new User(firstName: firstName, lastName: lastName)
        expect:
        user.name == name

        where:

        sno | firstName | lastName | name
        1   | "saloni"  | "sharma" | "saloni sharma"
        2   | ""        | "sharma" | "sharma"
        3   | null      | "sharma" | "sharma"
        4   | "shalika" | ""       | "shalika"
        5   | "shalika" | null     | "shalika"
        6   | null      | null     | ""
    }

}
