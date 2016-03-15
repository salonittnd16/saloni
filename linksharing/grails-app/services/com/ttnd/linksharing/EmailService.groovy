package com.ttnd.linksharing

import DTO.EmailDTO
import grails.transaction.Transactional

@Transactional
class EmailService {
    def mailService
    def messageSource

    def serviceMethod() {

    }

    def sendMail(EmailDTO emailDTO) {
        mailService.sendMail {
            to(emailDTO.to.toArray())
            subject(emailDTO.subject)
            if (emailDTO.content) {
                html(emailDTO.content)
            } else {
                html(view: emailDTO.view, model: emailDTO.model)
            }
        }
    }
    def sendUnreadResourcesEmail(User user,List<Resource> resourceList){
        EmailDTO emailDTO = new EmailDTO(to: [user.email],
                subject: messageSource.getMessage("com.ttnd.linksharing.DTO.EmailDTO.unread.subject", [].toArray(), Locale.default),
                view: "/email/unreadResources", model: [user: user, unreadResource: resourceList])
        sendMail(emailDTO)
    }
}
