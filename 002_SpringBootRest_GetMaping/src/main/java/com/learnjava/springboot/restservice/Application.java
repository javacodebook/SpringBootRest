package com.learnjava.springboot.restservice;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		String string = LocalDate.now(ZoneId.of("America/Chicago")).toString();
		System.out.println(string);
	}

	
}

