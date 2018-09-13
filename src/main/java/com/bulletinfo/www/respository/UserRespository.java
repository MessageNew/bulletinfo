package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
public interface UserRespository extends JpaRepository<User, Long> {

     public User findByUidAndPassword(Integer uid, String upwd);
}
