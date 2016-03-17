package com.ttnd.linksharing

import com.ttnd.linksharing.CO.DocumentResourceCO
import grails.transaction.Transactional


class DocumentResourceController extends ResourceController {

    def resourceService

    def index() { render "document resource section" }

    @Transactional
    def save(DocumentResourceCO documentResourceCO) {
        Topic topic = Topic.get(documentResourceCO.topicId)
        String filePath = "${grailsApplication.config.grails.folderPath}/${documentResourceCO.name}.pdf"
        DocumentResource documentResource = new DocumentResource(topic: topic, createdBy: session.user, description: documentResourceCO.description, contentType: documentResourceCO.contentType, filePath: filePath)
        User user = session.user
        Long sessionId = session.user.id
        user.refresh()

        if (documentResource.validate()) {

            File file1 = new File(filePath) << documentResourceCO.myFile.bytes
            if (documentResource.save(failOnError: true)) {
                flash.message = "document resource saved"
                render(flash.message)
                ReadingItem readingItem = resourceService.addToReadingItems(documentResource, sessionId)
                ResourceRating resourceRating = new ResourceRating(user: readingItem.user, resource: readingItem.resource, score: 4)
                resourceRating.save(flush: true)
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
        } else
            render "failed"
    }
}
