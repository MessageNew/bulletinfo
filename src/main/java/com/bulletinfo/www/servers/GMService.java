package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.GroupMessage;
import com.bulletinfo.www.respository.GMResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/13.
 */
@Service
public class GMService {
    @Autowired
    private GMResponsitory gmResponsitory;

    @Transactional
    public void SendGMsg(GroupMessage groupMessage){
        gmResponsitory.save(groupMessage);
    }

    public List SelectGidMsg(Integer gid){
        return gmResponsitory.findByGid(gid);
    }
}
