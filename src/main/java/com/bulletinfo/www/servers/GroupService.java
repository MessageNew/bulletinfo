package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.Groups;
import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.respository.GroupResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/13.
 */
@Service
public class GroupService {
    @Autowired
    private GroupResponsitory groupResponsitory;

    @Autowired
    private UserServers userServers;

    @Transactional
    public void CreateGroup(Groups groups){
        Integer gid = Integer.valueOf(String.valueOf(groupResponsitory.count())) + 1;
        groups.setgId(gid);
        Integer uid = groups.getgMaster();
        groupResponsitory.save(groups);
        User user = userServers.SelectUInfo(uid);
        String lists = null;
        if(user.getGidList() == null){
            lists = String.valueOf(gid);
        } else {
            lists = user.getGidList().toString();
            lists += ","+gid;
        }
        userServers.UpdateGidlists(lists, uid);
    }

    public List SelectGPersons(Integer gid){
        Groups groups = groupResponsitory.findBygId(gid);
        List list = Arrays.asList(groups.getgPersonnel().toString().split(","));
        return list;
    }

    @Transactional
    public void UpdateGpersonnel(String gPersonnel,Integer gId){
        groupResponsitory.UpdateGpersonnel(gPersonnel,gId);
    }

    @Transactional
    public void DelGroup(Integer gId){
        groupResponsitory.DelGroup(gId);
    }

}
