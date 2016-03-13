package com.ttnd.linksharing.Enum

/**
 * Created by saloni on 13/3/16.
 */

enum ActiveStatus {
    ALL_USERS("All user"),
    ACTIVE("Active"),
    INACTIVE("Inactive")


    final String value

    ActiveStatus(String value) {
        this.value = value
    }

    String toString() { value }

    String getKey() { name() }
}

