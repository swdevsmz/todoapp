package com.todoapp.backapp.business;

import com.todoapp.backapp.domain.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();
}
