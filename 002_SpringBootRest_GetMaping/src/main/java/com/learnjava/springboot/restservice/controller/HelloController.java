package com.learnjava.springboot.restservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "OK";
	}	
	
	
	
	
	
}
