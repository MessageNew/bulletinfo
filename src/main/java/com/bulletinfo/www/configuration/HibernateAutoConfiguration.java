package com.bulletinfo.www.configuration;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Mysteriouseyes on 2018/9/10.
 */
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
public class HibernateAutoConfiguration {
    @Bean
    public SessionFactory sessionFactory(EntityManagerFactory factory){
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return factory.unwrap(SessionFactory.class);
    }
}
