package com.learnjava.springboot.restservice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timeapi")
public class WorldTimeController {
	
	@GetMapping("/getcurrenttime")
	public String getCurrentTime() {
		return LocalTime.now().toString();
	}
	
	@GetMapping("/getcurrentdate")
	public String getCurrentDate(){
		return LocalDate.now().toString();
	}
	
	@GetMapping("/getcurrenttimestamp")
	public String getCurrentTimeStamp(){
		return LocalDateTime.now().toString();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getcsttime")
	public String getCurrentCSTTime(){		
		return LocalTime.now(ZoneId.of("America/Chicago")).toString();	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getcurrenttimezone")
	public String getCurrentTimeZone(){			
		return TimeZone.getDefault().toString();		
	}

}
