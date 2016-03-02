package com.ttnd.linksharing

class DemoTagLib {
    static defaultEncodeAs = [taglib: 'html']
    static namespace = "ls"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def showAdmin = { attrs, body ->
        Boolean isAdmin=Boolean.valueOf(attrs.admin)
        if (isAdmin) {
            out << body()
        }

    }
}
