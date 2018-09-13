package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/13.
 */
public interface GMResponsitory extends JpaRepository<GroupMessage, Integer> {
    public List<GroupMessage> findByGid(Integer gid);
}
