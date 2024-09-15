package com.todoapp.backapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.todoapp.backapp.persistance.mapper") //
public class BackappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackappApplication.class, args);
	}

}
