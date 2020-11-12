package com.tyeporter.todoapp.Service;

import java.util.Optional;
import java.util.UUID;

import com.tyeporter.todoapp.Model.TodoList;
import com.tyeporter.todoapp.Repo.TodoListRepo;

import org.json.simple.JSONObject;

public class TodoListServiceImpl implements TodoListService {

	TodoListRepo repo;

	public TodoListServiceImpl(TodoListRepo repo) {
		this.repo = repo;
	}

	@Override
	public Optional<TodoList> getTodoListById(UUID id) {
		return repo.findById(id);
	}

	@Override
	public Optional<TodoList> getTodoListByTitle(String title) {
		return repo.findTodoListByTitle(title);
	}

	@Override
	public Iterable<TodoList> getAllTodoList() {
		return repo.findAll();
	}

	@Override
	public JSONObject deleteAllTodoLists() {
		repo.deleteAll();

		JSONObject response = new JSONObject();
		response.put("message", "Deleted all todo lists");
		return response;
	}

	@Override
	public JSONObject deleteTodoListById(UUID id) {
		repo.deleteById(id);
		
		JSONObject response = new JSONObject();
		response.put("message", "Deleted todo list");
		return response;
	}

	@Override
	public JSONObject updateTodoListById(UUID id, TodoList newTodoList) {
		Optional<TodoList> todoList = repo.findById(id);
		todoList.map(updatedTodoList -> {
			updatedTodoList.setTitle(newTodoList.getTitle());
			updatedTodoList.setTasks(newTodoList.getTasks());
			return todoList;
		});

		JSONObject response = new JSONObject();
		response.put("message", "Updated todo list");
		return response;
	}

	@Override
	public JSONObject createTodoList(TodoList todoList){
		repo.save(todoList);

		JSONObject response = new JSONObject();
		response.put("message", "Created todo list");
		return response;
	}

}