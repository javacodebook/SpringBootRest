package com.learnjava.springboot.restservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnjava.springboot.restservice.model.Todo;
import com.learnjava.springboot.restservice.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {

	@Autowired
	TodoRepository todoRepository ;
	
	@Override
	public List<Todo> getTodosByUser(String user) {
		return todoRepository.findByUserName(user);
	}

	@Override
	public Optional<Todo> getTodoById(long id) {
		return todoRepository.findById(id);
	}

	@Override
	public List<Todo> allTodos() {
		return todoRepository.findAll();
	}
	
	@Override
	public String updateTodo(Todo todo) {
		return todoRepository.update(todo);  
	}

	
	@Override
	public Todo addTodo(Todo todo) {
		return todoRepository.save(todo);  
	}
}