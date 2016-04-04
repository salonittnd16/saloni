package com.ttnd.linksharing

import DTO.EmailDTO
import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.Constants.Constant
import grails.test.GrailsMock
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.web.multipart.MultipartFile
import spock.lang.IgnoreRest
import spock.lang.Specification


/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([ReadingItem, Subscription, User])
class UserControllerSpec extends Specification {
    @IgnoreRest
    void "testing for action index"() {
        given:
        Subscription.metaClass.static.findAllByUser = { return [new Subscription()] }
        ReadingItem.metaClass.static.findAllByUser = { user, map -> return [new ReadingItem()] }
        User.metaClass.subscribedTopics = [new Topic()]
        controller.session.user = new User()
        when:
        controller.index()
        then:
        view == "/user/dashboard"
        model.subscriptions.size() == 1
        model.readingItems.size() == 1
        model.listOfTopics.size() == 1
    }

    void "testing for register action when user is already registered"() {
        given:
        UserCo co = new UserCo()
        controller.session.user = new User()

        when:
        controller.register(co)
        then:
        flash.error == "already registered!!!!"
    }


    void "testing for register action for a new user"() {
        given:
        params.pic = GrailsMock(MultipartFile)
        UserCo co = new UserCo(firstName: "saloni", lastName: "sharma", email: "saloni@gmail.com", password: Constant.DEFAULT_PASSWORD, userName: "saloni", confirmPassword: Constant.DEFAULT_PASSWORD)
        User user = new User(firstName: co.firstName, lastName: co.lastName, userName: co.userName,
                email: co.email, password: co.password, confirmPassword: co.confirmPassword)

        when:
        controller.register(co)
        then:
        flash.message == "${user.firstName} registered successfully"
    }


    @IgnoreRest
    def "test for forgot password"() {
        given:
        String email = "saloni@gmail.com"
        User user = new User(email: email,active: true)
        user.save(validate: false)
        Utility.metaClass.static.getRandomPassword = { -> return "abcdefg" }

        and:
        def mockedEmailService = Mock(EmailService)
        controller.emailService = mockedEmailService

        when:
        controller.forgotPassword("saloni@gmail.com")


        then:
        1 * mockedEmailService.sendMail(new EmailDTO())
        user.password == "abcdefg"
        response.redirectUrl == "/login/index"


    }

}


