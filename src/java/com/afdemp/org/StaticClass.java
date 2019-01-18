/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.org;

/**
 *
 * @author George.Pasparakis
 */
public class StaticClass {
    static private long userId;
    static private String jsessionid;

    public String getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(String aJsessionid) {
        jsessionid = aJsessionid;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    
}
