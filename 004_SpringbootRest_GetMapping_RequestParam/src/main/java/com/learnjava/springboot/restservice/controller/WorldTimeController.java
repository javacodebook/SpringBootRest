package com.learnjava.springboot.restservice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.TimeZone;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/timeapi")
public class WorldTimeController {
	
	
	@GetMapping("/allzoneinfo" )
	public String getAllTimeZone() {
		String[] timeZones = TimeZone.getAvailableIDs();

		return ArrayUtils.toString(timeZones);
	}
	@GetMapping("/timebyzone")
	public String getTDateimeBasedOnZone(@RequestParam String userTimeZone) {
		TimeZone timeZone = TimeZone.getTimeZone(userTimeZone);
		ZoneId zoneId2 = timeZone.toZoneId();
		LocalDateTime localTime = LocalDateTime.now(zoneId2);
		return "The Current date and time at " + userTimeZone + " is " + localTime.toString();
	}

	@GetMapping("/timebyzone/time")
	public String getTimeBasedOnZone(@RequestParam String userTimeZone) {
		TimeZone timeZone = TimeZone.getTimeZone(userTimeZone);
		ZoneId zoneId2 = timeZone.toZoneId();
		LocalTime localTime = LocalTime.now(zoneId2);
		return "The Current Time at " + userTimeZone + " is " + localTime.toString();
	}

	@GetMapping("/timebyzone/date")
	public String getDateBasedOnZone(@RequestParam String userTimeZone) {
		TimeZone timeZone = TimeZone.getTimeZone(userTimeZone);
		ZoneId zoneId2 = timeZone.toZoneId();
		LocalDate localDate = LocalDate.now(zoneId2);
		return "The Current Date at " + userTimeZone + " is " + localDate.toString();
	}

	@GetMapping("/timebyzoneinfo")
	public String getDateAndTimeOnZone(@RequestParam String userTimeZone) {
		TimeZone timeZone = TimeZone.getTimeZone(userTimeZone);
		ZoneId zoneId2 = timeZone.toZoneId();
		LocalDateTime localDateTime = LocalDateTime.now(zoneId2);
		return localDateTime.toString();

	}

}
