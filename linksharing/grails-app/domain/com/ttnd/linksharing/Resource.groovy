package com.ttnd.linksharing

 abstract class Resource {

    String description;
    User createdBy;
    Topic topic;
    Date DateCreated;
    Date lastUpdated;

    static mapping = {description(type:'text')}

    static constraints = {
    }
    static hasMany = [resourceRatings:ResourceRating,readingItems:ReadingItem]
    static belongsTo = [topic:Topic]
}
