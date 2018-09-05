package com.bulletinfo.www.servers;

import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Service
public class UserServers {
    @Autowired
    private UserRespository userRespository;

    public void AddUser(User user){
        userRespository.save(user);
    }

    //查询一个信息
    //grilRespository.findOne(id);
    //更新一个信息,需要传入id
    //@PutMapping(value = "/update")
    //put 更倾向于更新操作，post倾向于新增
    //grilRespository.save(gril);
    //删除操作
    //@DeleteMapping(value = "/delete")
    //grilRespository.delete(id);
}
