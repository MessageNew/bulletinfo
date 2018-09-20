package com.bulletinfo.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BulletinfoApplication {

	private static Integer port = 8000;

	public static void main(String[] args) {
		//springboot启动
		SpringApplication.run(BulletinfoApplication.class, args);
	}
}
