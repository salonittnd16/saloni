package com.ttnd.linksharing

import spock.util.mop.Use

class ReadingItem {
    Boolean isRead;
    Date dateCreated;
    Date lastUpdated;


    static constraints = {
        resource unique:'user',nullable:false
        user nullable:false
    }
    static belongsTo = [user:User,resource:Resource]

    def executeUpdate() {
        User user = User.get(1)
        String firstName = user.firstName
        User.executeUpdate("update User as u set u.firstName=:firstName where u.id=:id", [firstName: "Test", id: 1.toLong()])
        render "firstName before ${firstName} -: After updation ${user.firstName}"
        User.executeUpdate("delete User where id=:id", [id: 1.toLong()])
    }
}
