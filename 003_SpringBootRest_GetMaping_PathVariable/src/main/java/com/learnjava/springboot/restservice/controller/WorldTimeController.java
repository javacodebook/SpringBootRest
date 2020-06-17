package com.learnjava.springboot.restservice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.TimeZone;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timeapi")
public class WorldTimeController {

	@GetMapping("/allzoneinfo")
	public String getAllTimeZone() {
		String[] timeZones = TimeZone.getAvailableIDs();

		return ArrayUtils.toString(timeZones);
	}

	@GetMapping("/gettimebyzone/{userTimeZone}")
	public String getTDateimeBasedOnZone(@PathVariable String userTimeZone) {
		TimeZone timeZone = TimeZone.getTimeZone(userTimeZone);
		ZoneId zoneId2 = timeZone.toZoneId();
		LocalDateTime localTime = LocalDateTime.now(zoneId2);
		return "The Current date and time at " + userTimeZone + " is " + localTime.toString();
	}

	@GetMapping("/gettimebyzone/{userTimeZone}/time")
	public String getTimeBasedOnZone(@PathVariable String userTimeZone) {
		TimeZone timeZone = TimeZone.getTimeZone(userTimeZone);
		ZoneId zoneId2 = timeZone.toZoneId();
		LocalTime localTime = LocalTime.now(zoneId2);
		return "The Current Time at " + userTimeZone + " is " + localTime.toString();
	}

	@GetMapping("/gettimebyzone/{userTimeZone}/date")
	public String getDateBasedOnZone(@PathVariable String userTimeZone) {
		TimeZone timeZone = TimeZone.getTimeZone(userTimeZone);
		ZoneId zoneId2 = timeZone.toZoneId();
		LocalDate localDate = LocalDate.now(zoneId2);
		return "The Current Date at " + userTimeZone + " is " + localDate.toString();
	}

	@GetMapping("/gettimebyzone/{userTimeZone}/date/{param}")
	public String getDateBasedOnZone(@PathVariable String userTimeZone, @PathVariable String param) {
		TimeZone timeZone = TimeZone.getTimeZone(userTimeZone);
		ZoneId zoneId2 = timeZone.toZoneId();
		LocalDate localDate = LocalDate.now(zoneId2);

		if ("month".equals(param)) {
			Month month = localDate.getMonth();
			return "The Current Month at " + userTimeZone + " is " + month.toString();
		} else if ("day".equals(param)) {
			int dayOfMonth = localDate.getDayOfMonth();
			return "The Current day at " + userTimeZone + " is " + dayOfMonth;
		} else if ("year".equals(param)) {
			int year = localDate.getYear();
			return "The Current year at " + userTimeZone + " is " + year;
		} else {
			return "invalid type";
		}
	}

}
