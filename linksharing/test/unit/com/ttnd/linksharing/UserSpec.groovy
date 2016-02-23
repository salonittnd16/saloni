package com.ttnd.linksharing

import com.ttnd.linksharing.Constants.Constant
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
        sno | fname        | lname     | email              | password  | admin | active | uname     | valid
        1   | ""           | "hello"   | "a@b.com"          | "test123" | false | false  | ""        | false
        2   | "Saloni"     | "sharma"  | "saloni@gmail.com" | "test123" | false | true   | "sal30"   | true
        3   | "Shalika123" | "hello"   | "shalika"          | "test123" | true  | true   | "shal123" | false
        4   | "Saloni"     | "sharma"  | "saloni@gmailcom"  | "test123" | true  | true   | "sal30"   | false
        5   | "Saloni"     | "sharma"  | ""                 | "hello"   | false | false  | "abc"     | false
        6   | "Shalika"    | "singhal" | null               | "abc"     | true  | true   | "shal"    | false
        7   | "Saloni"     | "sharma"  | "saloni@gmailcom"  | ""        | true  | true   | "sal30"   | false
        8   | "Saloni"     | "sharma"  | "saloni@gmailcom"  | null      | true  | true   | "sal30"   | false
        9   | "Saloni"     | "sharma"  | "saloni@gmailcom"  | "te"      | true  | true   | "sal30"   | false
        10  | null         | "sharma"  | "saloni@gmail.com" | "test123" | false | true   | "sal30"   | false
        11  | "Saloni"     | null      | "saloni@gmail.com" | "test123" | false | true   | "sal30"   | false
        12  | "Saloni"     | ""        | "saloni@gmail.com" | "test123" | false | true   | "sal30"   | false


    }

    def "email id of user should be unique"() {
        given:
        User user1 = new User(firstName: "saloni", lastName: "sharma", email: "saloni@tothenew.com", password: "saloni", userName: "ss")

        when:
        user1.save()


        then:
        User.count() == 1

        when:
        User user2 = new User(firstName: "shalika", lastName: "gupta", email: "saloni@tothenew.com", password: "saloni", userName: "pg")
        user2.save()

        then:
        User.count() == 1
        user2.errors.allErrors.size() == 1
        user2.errors.getFieldErrorCount("email") == 1

    }


    @Unroll

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


    def "tostring"() {
        given:
        User user = new User(firstName: "saloni", lastName: "sharma", userName: "saloni", email: "saloni@tothenew.com", password: Constant.DEFAULT_PASSWORD)

        when:
        String s = user.toString()

        then:
        s == "saloni"
    }


}
