package com.ttnd.linksharing.CO

import org.springframework.web.multipart.MultipartFile

/**
 * Created by saloni on 8/3/16.
 */
class DocumentResourceCO {
    String description;
    Long topicId;
    String contentType
    MultipartFile myFile
    String name = UUID.randomUUID()

    String getContentType() {
        myFile.contentType
    }

    void setContentType() {
        contentType = myFile.contentType
    }
}
