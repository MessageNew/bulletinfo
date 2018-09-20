package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.RequestGMsg;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mysteriouseyes on 2018/9/20.
 */
public interface RequestGMsgResponsitory extends JpaRepository<RequestGMsg, Integer> {
}
