package com.learnjava.springboot.restservice.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Todo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JacksonXmlProperty
	@Min(value = 1, message = "Id can't be less than 1 or bigger than 999999")
	  @Max(999999)
	private int id;

	@JacksonXmlProperty
	@Size(max = 100)
	private String userName;

	@JacksonXmlProperty
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String description;

	@JacksonXmlProperty
	@NotNull
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