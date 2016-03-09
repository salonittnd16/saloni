package com.linksharing

import com.ttnd.linksharing.ReadingItem
import grails.converters.JSON

class ReadingItemController {

    def index() { render "reading items" }

    def changeIsRead(Long id, Boolean isRead) {
        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=isRead where r.id=id")) {
            render ([message: "status changed successfully"] as JSON)
        } else {

            render ([message: "status not changed"] as JSON)


        }
    }

}