package com.todoapp.backapp.business;

import java.util.List;
import java.util.Optional;

import com.todoapp.backapp.persistance.entity.Todo;

public interface TodoService {

    List<Todo> findAll();

    Optional<Todo> findById(Long id);

    boolean create(Todo todo);

    boolean update(Todo todo);

    boolean delete(Todo todo);

    Long countByDone();
}
