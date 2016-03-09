package com.ttnd.linksharing

import com.ttnd.linksharing.Constants.Constant
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@TestFor(LoginController)
@Mock([User, Resource])
class LoginControllerSpec extends Specification {

    def setup() {

        User user = new User(firstName: "saloni", lastName: "sharma", email: "saloni@gmail.com", password: Constant.DEFAULT_PASSWORD)
        user.save()
    }

    void "when user is available in session then user should be forwarded to user index action"() {
        setup:
        controller.session.user = new User()
        when:
        controller.index()
        then:
        response.forwardedUrl == "/user/index"
    }

    @IgnoreRest
    void "when user is not available in session then  top post and recent shares should be rendered"() {

        given:
        Resource post1 = new DocumentResource(filePath: "a/b/c", description: "helllo",
                createdBy: User.findByFirstName("saloni"))
        Resource post2 = new DocumentResource(filePath: "a/b/c", description: "helllo",
                createdBy: User.findByFirstName("saloni"))
        List<Resource> resources = [post1, post2]
        Resource.metaClass.static.topResources = { resources }
        Resource.metaClass.static.recentShares = { resources }

        when:
        controller.index()
        then:
        model.topPosts == resources && model.recentShares == resources
        view == '/login/home'

    }


    def "login"() {
        given:
        User user = new User(firstName: "shalika1", lastName: "Singhal1", email: "shalika1@gmail.com", password: password, userName: username,
                admin: true, active: true);
        if (!user.save()) {
            println("===============${user.errors.allErrors*.getDefaultMessage()}")
        }

        when:
        controller.login(username, password)
        then:
        response.redirectUrl == '/user/index'
        where:
        username | password
        "sha1"   | "abcdef1"


    }
}

