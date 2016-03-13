package DTO

/**
 * Created by saloni on 13/3/16.
 */
class EmailDTO {
    List<String> to
    String view
    String subject
    Map model = [:]

    static constraints = {
        to nullable: false
        view nullable: false
        subject nullable: false
        model nullable: true
    }
}
