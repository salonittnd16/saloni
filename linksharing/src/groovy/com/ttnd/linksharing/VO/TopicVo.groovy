package com.ttnd.linksharing.VO

import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.User

/**
 * Created by saloni on 23/2/16.
 */
class TopicVo {

    Long id
    String name
    Visibility visibility
    Integer count
    User createdBy

    String toString(){

        name
    }
}
