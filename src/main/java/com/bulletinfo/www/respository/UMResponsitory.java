package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.domain.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
public interface UMResponsitory extends JpaRepository<UserMessage, Integer> {
}