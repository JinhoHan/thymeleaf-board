package com.acma.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ThymeleafClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafClientApplication.class, args);
		log.info("========= Thymeleaf Front End App Start =========");
	}

}
