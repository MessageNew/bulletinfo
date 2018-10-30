package com.bulletinfo.www.servers;
import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.respository.UserRespository;
import com.bulletinfo.www.utils.Encipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.serial.SerialStruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@Service
public class UserServers {
    @Autowired
    private UserRespository userRespository;

    @Transactional
    public void AddUser(User user){
        String password = user.getPassword();
        String phone = user.getPhone();
        if (password!=null){
            password = Encipher.Encode1(password);
            user.setPassword(password);
            user.setPhone(phone);
        }
        userRespository.save(user);
    }

    public boolean Login(Integer uid, String upwd){
        User user = userRespository.findByUid(uid);
        String pw = Encipher.Decode1(user.getPassword());
        //User user = userRespository.findByUidAndPassword(uid, upwd);
        if(upwd.equals(pw)){
            return true;
        }
        return false;
    }

    public boolean CheckAccount(String phone){
        User user = userRespository.findByPhone(phone);
        if(user != null){
            return true;
        }
        return false;
    }

    public User SelectUInfo(Integer uid){
        return userRespository.findByUid(uid);
    }

    public User SelectByPhone(String phone){
        return userRespository.findByPhone(phone);
    }

    public void UpdateGidlists(String glists, Integer uid){
        userRespository.UpdateGidList(glists, uid);
    }

    public void UpdateIcourl(String icourl,String phone){
        userRespository.UpdateIcourl(icourl,phone);
    }

    @Transactional
    public void UpdatePw(String password,String phone) {
        password = Encipher.Encode1(password);
        userRespository.UpdatePw(password,phone);
    }

    public List SelectGidLists(Integer uid){
        User user = userRespository.findByUid(uid);
        List list = Arrays.asList(user.getGidList().toString().split(","));
        return list;
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
