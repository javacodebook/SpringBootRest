package com.learnjava.springboot.restservice.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;

import com.learnjava.springboot.restservice.model.Todo;

@Configuration
public class TodoRepository {

	static List<Todo> todoList = mockDB();

	public List<Todo> findAll() {

		return todoList;

	}

	public List<Todo> findByUserName(String user) {

		return todoList.stream().filter(todo -> todo.getUserName().equals(user)).collect(Collectors.toList());
	}

	public Optional<Todo> findById(long id) {

		return todoList.stream().filter(todo -> todo.getId() == id).findFirst();

	}

	private static List<Todo> mockDB() {

		List<Todo> mockDoList = new ArrayList<Todo>();

		mockDoList.add(new Todo(0, "Vijay", "Apply For Job", LocalDate.of(2019, 06, 30)));
		mockDoList.add(new Todo(1, "Vardhan", "Apply For Job", LocalDate.of(2018, 05, 21)));
		mockDoList.add(new Todo(2, "Vijay", "Java certification", LocalDate.of(2019, 02, 20)));
		mockDoList.add(new Todo(3, "Vardhan", "Visit School", LocalDate.of(2020, 03, 29)));
		mockDoList.add(new Todo(4, "Kiran", "Apply For Job", LocalDate.of(2019, 03, 22)));
		mockDoList.add(new Todo(5, "Vijay", "Buy Medicine", LocalDate.now()));

		return mockDoList;
	}

	public String update(Todo updateTodo) {

		String result = "Not Updated the todo";
		for (int index = 0; index < todoList.size(); index++) {
			Todo todo = todoList.get(index);

			if (todo.getId() == updateTodo.getId()) {
				todoList.add(index, updateTodo);
				result = "Updated the todo";
				break;
			}

		}

		return result;

	}

	public Todo save(Todo todo) {

		todoList.add(todo);

		return todo;

	}

	public String delete(long id) {

		String result = "Todo not Found";
		for (int index = 0; index < todoList.size(); index++) {
			Todo todo = todoList.get(index);

			if (todo.getId() == id) {
				todoList.remove(index);
				result = "Todo Deleted";
				break;
			}

		}

		return result;

	}

}
