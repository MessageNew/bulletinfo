package com.bulletinfo.www.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Entity
public class Friend {

    @Id
    @GeneratedValue
    private Integer id;

    private String Uid;
    private String UserName;

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

}
