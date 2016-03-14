package com.linksharing

import com.ttnd.linksharing.ReadingItem
import grails.converters.JSON

class ReadingItemController {

    def index() { render "reading items" }

    def changeIsRead(Long id, Boolean isRead) {
        Map result = [:]
        println(".............................>${id}#########################${isRead}")
        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=${isRead} where r.id=id")) {
            result.message = "status changed successfully"
        } else {

            result.error = "status not changed"
        }
        render(result as JSON)

    }

}