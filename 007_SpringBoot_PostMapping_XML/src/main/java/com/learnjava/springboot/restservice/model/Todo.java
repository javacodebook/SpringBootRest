package com.learnjava.springboot.restservice.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Todo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JacksonXmlProperty
	private int id;

	@JacksonXmlProperty
	private String userName;

	@JacksonXmlProperty
	private String description;

	@JacksonXmlProperty
	private LocalDate targetDate;

	public Todo() {
		super();
	}

	public Todo(int id ,String user, String desc, LocalDate targetDate) {
		super();
		this.id =id;
		this.userName = user;
		this.description = desc;
		this.targetDate = targetDate;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
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