package com.bulletinfo.www.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mysteriouseyes on 2018/9/19.
 */
@Entity
public class RequestMsg {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer putUser;
    private Integer getUser;
    private String message;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPutUser() {
        return putUser;
    }

    public void setPutUser(Integer putUser) {
        this.putUser = putUser;
    }

    public Integer getGetUser() {
        return getUser;
    }

    public void setGetUser(Integer getUser) {
        this.getUser = getUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
