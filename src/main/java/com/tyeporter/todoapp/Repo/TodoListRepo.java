package com.tyeporter.todoapp.Repo;

import java.util.UUID;

import java.util.Optional;
import com.tyeporter.todoapp.Model.TodoList;

import org.springframework.data.repository.CrudRepository;

public interface TodoListRepo extends CrudRepository<TodoList, UUID> {

	Optional<TodoList> findTodoListByTitle(String title);

}