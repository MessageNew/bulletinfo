package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.Friend;
import com.bulletinfo.www.respository.FResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.GeneratedValue;
import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Service
public class FServers {
    @Autowired
    private FResponsitory fResponsitory;

    @Transactional
    public List<Friend> UserList(Integer uid){
        List<Friend> list = fResponsitory.findByUid(uid);
        return list;
    }

    @Transactional
    public void DeleteFriend(Integer uid,Integer fid){
        fResponsitory.DeleteFriend(uid,fid);
    }

}
