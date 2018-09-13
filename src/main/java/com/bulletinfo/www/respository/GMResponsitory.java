package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mysteriouseyes on 2018/9/13.
 */
public interface GMResponsitory extends JpaRepository<GroupMessage, Integer> {
}
