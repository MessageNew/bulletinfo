package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.Friend;
import com.bulletinfo.www.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
public interface FResponsitory extends JpaRepository<Friend, Integer> {

}
