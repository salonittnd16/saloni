package com.ttnd.linksharing

class ResourceController {

    def index() {
        render "resources section"

    }

    def delete(int id)
    {   try {
        Resource resource = Resource.load(id)
        render "resource deleted : ${resource.id}"
        resource.delete(flush: true)

    }
    catch (Exception e){
        render(e.message)
    }

    }
}
