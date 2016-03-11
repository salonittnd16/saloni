package com.ttnd.linksharing

import com.ttnd.linksharing.CO.DocumentResourceCO
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

import javax.mail.Multipart

class DocumentResourceController extends ResourceController {

//    def grailsApplication

    def index() { render "document resource section" }

    @Transactional
    def save(DocumentResourceCO documentResourceCO) {
        Topic topic = Topic.get(documentResourceCO.topicId)
        String filePath = "${grailsApplication.config.grails.folderPath}/${documentResourceCO.name}.pdf"
        DocumentResource documentResource = new DocumentResource(topic: topic, createdBy: session.user, description: documentResourceCO.description, contentType: documentResourceCO.contentType, filePath: filePath)
        User user = session.user
        user.refresh()

        if (documentResource.validate()) {

            File file1 = new File(filePath) << documentResourceCO.myFile.bytes
            if (documentResource.save(failOnError: true)) {
                flash.message = "document resource saved"
                render(flash.message)
                ReadingItem readingItem = addToReadingItems(documentResource)
                ResourceRating resourceRating = new ResourceRating(user: readingItem.user, resource: readingItem.resource, score: 4)
                resourceRating.save(flush: true)
                println resourceRating
                user.addToResourceRatings(resourceRating)
            }
        } else {
            render(documentResource.errors)
        }

    }

    def download(Long id) {
        DocumentResource documentResource = DocumentResource.get(id)
        if (documentResource && (documentResource.topic.canViewedBy(session.user.id))) {
            File file = new File(documentResource.filePath)
            println "..................>>>${file.bytes}"
            response.setHeader("Content-disposition", "attachment; filename=" + documentResource.fileName)
            response.contentType = documentResource.contentType
            response.outputStream << file.newInputStream()
//            render "success"

        } else
            render "failed"
    }
}
