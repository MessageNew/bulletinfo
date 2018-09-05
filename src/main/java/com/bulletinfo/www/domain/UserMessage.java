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

    private String FName;
    private String Send_GetUser;
    private String Send_Get;
    private String Get_SendUser;
    private String Message;
    private String time;

    public Integer getId() {
        return id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setId(Integer id) {
        this.id = id;

    }


    public String getSend_GetUser() {
        return Send_GetUser;
    }

    public void setSend_GetUser(String send_GetUser) {
        Send_GetUser = send_GetUser;
    }

    public String getSend_Get() {
        return Send_Get;
    }

    public void setSend_Get(String send_Get) {
        Send_Get = send_Get;
    }

    public String getGet_SendUser() {
        return Get_SendUser;
    }

    public void setGet_SendUser(String get_SendUser) {
        Get_SendUser = get_SendUser;
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
