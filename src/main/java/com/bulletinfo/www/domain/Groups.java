package com.bulletinfo.www.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Mysteriouseyes on 2018/9/13.
 */
@Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*群名，群人员（用户ID），建群时间，群主，群ID*/
    private Integer gId;
    private String gName;
    private String gPersonnel;
    private String time;
    private Integer gMaster;


    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgPersonnel() {
        return gPersonnel;
    }

    public void setgPersonnel(String gPersonnel) {
        this.gPersonnel = gPersonnel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getgMaster() {
        return gMaster;
    }

    public void setgMaster(Integer gMaster) {
        this.gMaster = gMaster;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }
}
