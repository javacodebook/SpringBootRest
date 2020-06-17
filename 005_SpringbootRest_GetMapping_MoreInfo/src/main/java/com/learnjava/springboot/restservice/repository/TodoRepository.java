package com.learnjava.springboot.restservice.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.learnjava.springboot.restservice.model.Todo;


public interface TodoRepository {

	static List<Todo> todoList = mockDB();

	default List<Todo> findAll() {

		return todoList;

	}

	default List<Todo> findByUserName(String user) {

		return todoList.stream().filter(todo -> todo.getUserName().equals(user)).collect(Collectors.toList());
	}

	default Optional<Todo> findById(long id) {

		return todoList.stream().filter(todo -> todo.getId() == id).findFirst();

	}

	static List<Todo> mockDB() {

		List<Todo> mockDoList = new ArrayList<Todo>();

		mockDoList.add(new Todo((long) 1, "Vijay", "Apply For Job", LocalDate.of(2019, 06, 30)));
		mockDoList.add(new Todo((long) 2, "Vardhan", "Apply For Job", LocalDate.of(2018, 05, 21)));
		mockDoList.add(new Todo((long) 3, "Vijay", "Java certification", LocalDate.of(2019, 02, 20)));
		mockDoList.add(new Todo((long) 4, "Vardhan", "Visit School", LocalDate.of(2020, 03, 29)));
		mockDoList.add(new Todo((long) 5, "Kiran", "Apply For Job", LocalDate.of(2019, 03, 22)));
		mockDoList.add(new Todo((long) 6, "Vijay", "Buy Medicine", LocalDate.now()));

		return mockDoList;
	}

}
