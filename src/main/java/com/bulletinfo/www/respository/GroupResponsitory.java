package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mysteriouseyes on 2018/9/13.
 */
public interface GroupResponsitory extends JpaRepository<Groups, Integer> {
    public Groups findBygId(Integer gid);
}
