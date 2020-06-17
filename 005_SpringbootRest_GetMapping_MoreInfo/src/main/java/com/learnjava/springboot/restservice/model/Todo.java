package com.learnjava.springboot.restservice.model;

import java.time.LocalDate;

public class Todo {

	private long id;

	private String userName;

	private String description;

	private LocalDate targetDate;

	public Todo() {
		super();
	}

	public Todo(Long id ,String user, String desc, LocalDate targetDate) {
		super();
		this.id =id;
		this.userName = user;
		this.description = desc;
		this.targetDate = targetDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
}