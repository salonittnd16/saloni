package com.ttnd.linksharing

class User {

    String firstName;
    String lastName;
    String userName;
    String password;
    String email;
    String confirmPassword
    Byte[] photo;
    Boolean admin;
    Boolean active;
    Date dateCreated;
    Date lastUpdated;

    static mapping = { photo(type: 'blob')
    sort id:"desc"}

    static transients = ['name', 'confirmPassword']


    static constraints = {
        email unique: true, email: true, blank: false, nullable: false
        password nullable: false, blank: false, minSize: 5
        firstName nullable: false, blank: false
        lastName nullable: false, blank: false
        photo nullable: true
        admin nullable: true
        active nullable: true
        confirmPassword(bindable:true,nullable: true, blank: true, validator: { val, obj ->
//           if(val) {
               if (obj.password != val) {
                   return "passwords.don't.match"
               }
//           }
        })


    }
    static hasMany = [topics: Topic, subscriptions: Subscription, resources: Resource, readingItems: ReadingItem, resourceRatings: ResourceRating]

    String getName() {
        [firstName, lastName].findAll { it }.join(' ')

    }

    String toString() {
        firstName

    }

}
