package com.im.test

import spock.lang.Specification

class UserSpec extends Specification {

    def "First test"() {
        expect:
        true    //false then the test case will fail
    }

    def "get  full name"() {
        given: " user first name "
        User user = new User();
        user.firstName = "saloni"

        and: "user last name"
        user.lastName = "sharma"


        when:
        String check = user.getFullName()

        then:
        user.firstName + " " + user.lastName == check


    }

    def "display name"() {
        given: "gender and full name"
        User user = new User(firstName: fn, lastName: ln, gender: gen)

        when:
        String s = user.displayName()

        then:
        s == result

        where:

        fn       | ln       | gen      | result
        "saloni" | "sharma" | "Female" | "Mssaloni sharma"
        "nitin"  | "singh"  | "Male"   | "Mrnitin singh"


    }

    def "is the password valid"() {
        given: "a user"
        User user = new User()

        when:
        Boolean validpassword = user.isValidPassword(pwd)

        then:
        validpassword == expectedpassword

        where:
        pwd            | expectedpassword
        "ss"           | false
        "salonisharma" | true
        null           | false


    }


    def "reset password"() {
        setup: "a user"
        User user = new User(password: currpwd)
        user.metaClass.encyryptPassword={String str->
            return "okay"}

        and:
        def mockedEmailService = Mock(EmailService)
        user.emailService = mockedEmailService
        1 * mockedEmailService.sendCancellationEmail(_ as User, _ as String)


        when:
       user.resetPasswordAndSendEmail()

        then:
        user.password =="okay"

        where:
        currpwd="mypassword"

    }


    def "encrypt supplied password"() {
        given: "a user"
        User user = new User(password: currpwd)

        and:
        def mockedEncrypterService = Mock(PasswordEncrypterService)
        user.passwordEncrypterService = mockedEncrypterService

        and: "stub encrypt method"
        mockedEncrypterService.encrypt(currpwd) >> {result}

        when:
        String encryptedpassword = user.encyryptPassword(currpwd)

        then:
        encryptedpassword == result

        where:
        currpwd      | result
        "test"       | null
        "mypassword" | "okay"

    }


    def "group according to incomes"() {
        given: "a user"
        User user = new User(incomePerMonth: i)

        when:
        String group = user.getIncomeGroup()

        then:
        group == result

        where:

        i     | result
        4000  | "MiddleClass"
        6000  | "Lower MiddleClass"
        11000 | "Higher MiddleClass"
    }




    def"maintaining a list of purchased products"()
    {
        given:"a user"
        User user=new User();

        and:" a list of products"
        user.purchasedProducts=[]


        and:"a product to be added"
        Product p=new Product(name:"handbag")

        when:
        user.purchase(p)

        then:
        user.purchasedProducts.contains(p)==true


    }


    def"removing a product from the list of purchased products"()
    {
        given:"a user"
        User user=new User();

        and:" a list of products"
        user.purchasedProducts=[]


        and:"a product to be removed"
        Product p=new Product(name:"handbag")

        when:
        user.cancelPurchase(p)

        then:
        user.purchasedProducts.contains(p)==false


    }






}