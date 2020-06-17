package com.learnjava.springboot.restservice.service;

import java.util.List;
import java.util.Optional;

import com.learnjava.springboot.restservice.model.Todo;

public interface ITodoService {

	List<Todo> getTodosByUser(String user);

	Optional<Todo> getTodoById(long id);

	List<Todo> allTodos();

	String updateTodo(Todo todo);

	Todo addTodo(Todo todo);

}