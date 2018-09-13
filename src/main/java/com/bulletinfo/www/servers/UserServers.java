package com.bulletinfo.www.servers;
import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Service
public class UserServers {
    @Autowired
    private UserRespository userRespository;

    @Transactional
    public void AddUser(User user){
        user.setUid(Integer.valueOf(String.valueOf(userRespository.count())) + 1);
        userRespository.save(user);
    }

    public boolean Login(Integer uid, String upwd){
        User user = userRespository.findByUidAndPassword(uid, upwd);
        if(user != null){
            return true;
        }
        return false;
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
