package com.bulletinfo.www.respository;

import com.bulletinfo.www.domain.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Mysteriouseyes on 2018/9/13.
 */
public interface GroupResponsitory extends JpaRepository<Groups, Integer> {
    public Groups findBygId(Integer gid);

    @Modifying
    @Query("update Groups g set g.gPersonnel=?1 where g.gId=?2")
    public void UpdateGpersonnel(String gPersonnel,Integer gId);

    @Modifying
    @Query("delete from Groups g where g.gId=?1")
    public void DelGroup(Integer gId);
}
