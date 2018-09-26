package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.Friend;
import com.bulletinfo.www.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
public interface FResponsitory extends JpaRepository<Friend, Integer> {

    List<Friend> findByUid(Integer uid);

    @Modifying
    @Query("delete from Friend f where f.uid=:uid and f.fid=:fid")
    void DeleteFriend(@Param("uid")Integer uid, @Param("fid")Integer fid);
}
