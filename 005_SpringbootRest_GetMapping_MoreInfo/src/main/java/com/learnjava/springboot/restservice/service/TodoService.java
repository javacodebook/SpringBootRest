package com.learnjava.springboot.restservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learnjava.springboot.restservice.model.Todo;
import com.learnjava.springboot.restservice.repository.TodoRepository;

@Service
public class TodoService implements ITodoService, TodoRepository {

	@Override
	public List<Todo> getTodosByUser(String user) {
		return findByUserName(user);
	}

	@Override
	public Optional<Todo> getTodoById(long id) {
		return findById(id);
	}

	@Override
	public List<Todo> allTodos() {
		return findAll();
	}

}