package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

/**
 * Created by Mysteriouseyes on 2018/9/12.
 */
public interface UMResponsitory extends JpaRepository<UserMessage, Integer> {

}
