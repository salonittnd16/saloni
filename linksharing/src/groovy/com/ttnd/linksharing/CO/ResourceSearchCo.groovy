package com.ttnd.linksharing.CO

import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.User

/**
 * Created by saloni on 23/2/16.
 */
class ResourceSearchCo extends SearchCo {
    Long topicId
    Visibility visibility
    Long id
    User getUser(){
        User user=User.get(id)
        user
    }

}
