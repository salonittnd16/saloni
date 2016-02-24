package com.linksharing

import com.ttnd.linksharing.ReadingItem

class ReadingItemController {

    def index() { render "reading items" }

    def changeIsRead(Long id, Boolean isRead) {
        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=isRead where r.id=id")) {
            render 'successfully changed isRead'

        } else {
            flash.message = "updation unsuccessful!"
        }


    }
}

