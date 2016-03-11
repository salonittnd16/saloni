package com.ttnd.linksharing.CO

import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.User

/**
 * Created by saloni on 11/3/16.
 */
class TopicSearchCo extends SearchCo {
    Long id // user id
    Visibility visibility

    User getUser(){
        User user=User.get(id)
        user
    }
}
