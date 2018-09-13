package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.Groups;
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

    @Transactional
    public void CreateGroup(Groups groups){
        groups.setgId(Integer.valueOf(String.valueOf(groupResponsitory.count())) + 1);
        groupResponsitory.save(groups);
    }

    public List SelectGPersons(Integer gid){
        Groups groups = groupResponsitory.findBygId(gid);
        List list = Arrays.asList(groups.getgPersonnel().toString().split(","));
        return list;
    }

}
