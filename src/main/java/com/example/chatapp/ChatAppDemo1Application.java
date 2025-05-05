package com.example.chatapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;

@SpringBootApplication
@MapperScan("com.example.chatapp.mapper")
public class ChatAppDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(ChatAppDemo1Application.class, args);
	}

}
