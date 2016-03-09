package com.ttnd.linksharing
/**
 * Created by saloni on 7/3/16.
 */
class CustomBean {
    String fname;
    String lname;

    String getFname() {
        return fname
    }

    void setFname(String fname) {
        println("********************************fname setter**********************************************")
        this.fname = fname
    }

    String getLname() {
        return lname
    }

    void setLname(String lname) {
        println("lname setter")
        this.lname = lname
    }
    CustomBean(){

    }

    CustomBean(lastname){
        fname="deepti"
        println("*************************************constructor*******************************************")
        lname=lastname
    }
}
