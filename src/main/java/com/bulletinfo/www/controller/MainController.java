package com.bulletinfo.www.controller;

import com.bulletinfo.www.domain.Result;
import com.bulletinfo.www.domain.User;
import com.bulletinfo.www.domain.UserMessage;
import com.bulletinfo.www.respository.UserRespository;
import com.bulletinfo.www.servers.UserServers;
import com.bulletinfo.www.utils.ResultUtils;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by Mysteriouseyes on 2018/9/5.
 */
@RestController
public class MainController {

    @Autowired
    private UserServers us;

    @Autowired
    private UserRespository userRespository;

    @GetMapping(value = "/")
    public String MainTest(){
        return "hello";
    }

    @PostMapping("/reginster")
    public Result Register(@Valid User user) throws SQLException {
        System.out.println("user is:"+user);
        userRespository.save(user);
        return ResultUtils.success(new Object());
    }

}
