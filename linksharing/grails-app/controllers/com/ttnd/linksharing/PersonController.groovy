package com.ttnd.linksharing

import com.ttnd.linksharing.CO.PersonCO

class PersonController {

    def index() { render template:"/user/trendingtopics" }

    def autoBindings() {
        Person person = Person.get(1)
        render("----------------before")
        render person.properties
        render "<br>"
        person.properties = params
        render("----------------before")
        render person.properties


    }

    def paramsConversion() {

        int fage = params.float("age")
        Date dob = params.date("dob", "dd/mm/yyyy")
        render fage
        render dob

    }

    def binderrors() {
        println params
        def person = new Person(params)
        println person.hasErrors()
        if (person.hasErrors()) {
            println "the value ${person.errors.getFieldError('age')}"
            if (person.errors.hasFieldErrors("age")) {
                println person.errors.getFieldError("age").rejectedValue
            }

        }
    }


    def usingCO(PersonCO personCO){
        render personCO.properties
        render"<br>"
        render "---------------------------------"
        render personCO.errors
        render personCO.validate()
        render "<br>"
        if(personCO.hasErrors()){
            render personCO.errors.getFieldError("name").rejectedValue
        }
    }

}
