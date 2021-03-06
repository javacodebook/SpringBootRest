package com.learnjava.springboot.restservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.springboot.restservice.model.Todo;
import com.learnjava.springboot.restservice.service.ITodoService;

@RestController
public class TodoController {

	@Autowired
	private ITodoService todoService;

	@GetMapping(value = "/list-todos", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Todo> showTodos() {
		List<Todo> todosByUser = todoService.allTodos();

		return todosByUser;
	}

	@GetMapping("/list-user-todos")
	public List<Todo> showUserTodos(@Size(max = 100)  @RequestParam String userName) {
		List<Todo> todosByUser = todoService.getTodosByUser(userName);
		return todosByUser;
	}

	@GetMapping("/list-todo")
	public Todo showTodo(@Min(1) @Max(999999) @RequestParam long toDoId) {
		Todo todo = null;
		Optional<Todo> todosByUser = todoService.getTodoById(toDoId);
		if (todosByUser.isPresent()) {
			todo = todosByUser.get();
		}

		return todo;
	}

	@PostMapping(value = "/update-todo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateTodo(@NotBlank @RequestBody Todo todo) {

		return todoService.updateTodo(todo);

	}

	@PutMapping(value = "/add-todo", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);

	}
	
	@DeleteMapping(value = "/delete-todo")
	public String deleteTodo(@NonNull @RequestParam long id) {
		return todoService.deleteTodo(id);
		
		
	}

}
