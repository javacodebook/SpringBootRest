package com.learnjava.springboot.restservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.springboot.restservice.model.Todo;
import com.learnjava.springboot.restservice.service.ITodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController(value ="/todoapp" )
@Api(value="todoapp")
public class TodoController {

	@Autowired
	private ITodoService todoService;

	 @ApiOperation(value = "View a list of Todo",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	@GetMapping(value = "/list-todos", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<Todo> showTodos() {
		List<Todo> todosByUser = todoService.allTodos();

		return todosByUser;
	}

	 @ApiOperation(value = "View a list of user Todo",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	@GetMapping("/list-user-todos")
	public List<Todo> showUserTodos(@RequestParam String userName) {
		List<Todo> todosByUser = todoService.getTodosByUser(userName);
		return todosByUser;
	}
	 
	 
	 @ApiOperation(value = "View a list of Todo by id ",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )

	@GetMapping("/list-todo")
	public Todo showTodo(@RequestParam long toDoId) {
		Todo todo = null;
		Optional<Todo> todosByUser = todoService.getTodoById(toDoId);
		if (todosByUser.isPresent()) {
			todo = todosByUser.get();
		}

		return todo;
	}

	 @ApiOperation(value = "Update Todo",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	@PostMapping(value = "/update-todo", consumes = MediaType.APPLICATION_XML_VALUE)
	public String updateTodo(@RequestBody Todo todo) {

		return todoService.updateTodo(todo);

	}

	 @ApiOperation(value = "Add Todo",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	@PutMapping(value = "/add-todo", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);

	}
	
	 @ApiOperation(value = "Delete Todo",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	@DeleteMapping(value = "/delete-todo")
	public String deleteTodo(@RequestParam long id) {
		return todoService.deleteTodo(id);
		
		
	}

}
