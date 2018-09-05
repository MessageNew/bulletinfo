package com.bulletinfo.www.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer Uid;
    private String Username;
    private String time;
    private String password;
    private String Sex;
    private String phone;
    private String age;
    private String address;
    private String icourl;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Uid=" + Uid +
                ", Username='" + Username + '\'' +
                ", time='" + time + '\'' +
                ", password='" + password + '\'' +
                ", Sex='" + Sex + '\'' +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", icourl='" + icourl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIcourl() {
        return icourl;
    }

    public void setIcourl(String icourl) {
        this.icourl = icourl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Uid=" + Uid +
                ", Username='" + Username + '\'' +
                ", time='" + time + '\'' +
                ", password='" + password + '\'' +
                ", Sex='" + Sex + '\'' +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", icourl='" + icourl + '\'' +
                '}';
    }
}
