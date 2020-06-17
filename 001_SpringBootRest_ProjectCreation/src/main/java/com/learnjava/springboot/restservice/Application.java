/*
 * Spring Boot Rest Bare-Bone Example
 * 
 * Observe below points 
 * 
 * 1) check maven dependencies jar ( spring-boot-starter-web , Jackson Jars , Spring web , Spring webMVC ,,embed servers )
 * 2) Default port ,host system and port 
 * 3) spring boot version
 */
package com.learnjava.springboot.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
