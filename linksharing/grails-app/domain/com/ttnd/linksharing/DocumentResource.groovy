package com.ttnd.linksharing

import com.ttnd.linksharing.Constants.Constant

class DocumentResource extends Resource {


    String filePath;
    String contentType
    String fileName
    static transients = ['contentType', 'fileName']
    static constraints = {
        filePath nullable: false, blank: false
    }
    static mapping = {
        contentType bindable: true, validator: { val, obj, err ->
            if (val) {
                if (val != Constant.DOCUMENT_CONTENT_TYPE) {
                    return "content.type.not.set"
                } else
                    true
            }
        }
    }

    String getFileName() {
        List filePathNames = filePath.split("/")
        filePathNames.last()
    }

    String getContentType() {
        this.contentType
    }

    void setContentType(String cType) {
        contentType = cType
    }

    void deleteFile() {
        File file = new File(this.filePath)
        file.delete()
    }


    String toString() {
        description


    }
}
