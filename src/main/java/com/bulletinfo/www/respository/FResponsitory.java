package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.Friend;
import com.bulletinfo.www.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
public interface FResponsitory extends JpaRepository<Friend, Integer> {


    public List<Friend> findByUid(Integer uid);
}
