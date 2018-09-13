package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/12.
 */
public interface UMResponsitory extends JpaRepository<UserMessage, Integer> {
    public List<UserMessage> findByputUserInAndGetUserIn(List<Integer> plist, List<Integer> glist);
}
