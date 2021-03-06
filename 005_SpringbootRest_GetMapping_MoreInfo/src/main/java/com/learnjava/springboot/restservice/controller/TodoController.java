package com.learnjava.springboot.restservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.springboot.restservice.model.Todo;
import com.learnjava.springboot.restservice.service.ITodoService;

@RestController
public class TodoController {

	@Autowired
	private ITodoService todoService;

	@GetMapping("/list-todos")
	public List<Todo> showTodos() {
		List<Todo> todosByUser = todoService.allTodos();

		return todosByUser;
	}

	@GetMapping("/list-user-todos")
	public List<Todo> showUserTodos(@RequestParam String userName) {
		List<Todo> todosByUser = todoService.getTodosByUser(userName);
		return todosByUser;
	}

	@GetMapping("/list-todo")
	public Todo showTodo(@RequestParam long toDoId) {
		Todo todo = null;
		Optional<Todo> todosByUser = todoService.getTodoById(toDoId);
		if (todosByUser.isPresent()) {
			todo = todosByUser.get();
		}

		return todo;
	}

}
