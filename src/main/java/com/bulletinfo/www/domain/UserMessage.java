package com.bulletinfo.www.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Entity
public class UserMessage {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer put_User;
    private Integer get_User;
    private String message;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPut_User() {
        return put_User;
    }

    public void setPut_User(Integer put_User) {
        this.put_User = put_User;
    }

    public Integer getGet_User() {
        return get_User;
    }

    public void setGet_User(Integer get_User) {
        this.get_User = get_User;
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
