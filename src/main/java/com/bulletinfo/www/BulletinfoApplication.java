package com.bulletinfo.www;

import com.bulletinfo.www.servers.UserServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BulletinfoApplication {

	public static void main(String[] args) {
		//springboot启动
		SpringApplication.run(BulletinfoApplication.class, args);
	}
}
