package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.RequestMsg;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mysteriouseyes on 2018/9/19.
 */
public interface RequestMsgResponsitory extends JpaRepository<RequestMsg, Integer> {

}
