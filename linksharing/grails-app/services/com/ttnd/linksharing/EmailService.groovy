package com.ttnd.linksharing

import DTO.EmailDTO
import grails.transaction.Transactional

@Transactional
class EmailService {
    def mailService

    def serviceMethod() {

    }

    def sendMail(EmailDTO emailDTO) {
        mailService.sendMail {
            to(emailDTO.to.toArray())
            subject(emailDTO.subject)
            html(view: emailDTO.view, model: emailDTO.model)
        }
    }
}
