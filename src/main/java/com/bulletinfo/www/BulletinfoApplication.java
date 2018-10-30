package com.bulletinfo.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BulletinfoApplication extends SpringBootServletInitializer {

	private static Integer port = 8000;

	public static void main(String[] args) {
		//springboot启动
		SpringApplication.run(BulletinfoApplication.class, args);
	}
}
