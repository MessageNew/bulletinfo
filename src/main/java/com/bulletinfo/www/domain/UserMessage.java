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
    private String Put_User;
    private String Get_User;
    private String Message;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPut_User() {
        return Put_User;
    }

    public void setPut_User(String put_User) {
        Put_User = put_User;
    }

    public String getGet_User() {
        return Get_User;
    }

    public void setGet_User(String get_User) {
        Get_User = get_User;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
