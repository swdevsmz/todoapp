package com.todoapp.backapp.business;

import com.todoapp.backapp.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<Todo> findAll();

    Optional<Todo> findById(Long id);

    boolean create(Todo todo);

    boolean update(Todo todo);

    boolean delete(Todo todo);

    Long countByDone();
}
