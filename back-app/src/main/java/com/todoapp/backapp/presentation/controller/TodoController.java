package com.todoapp.backapp.presentation.controller;

import java.util.Arrays;
import java.util.List;

import com.todoapp.backapp.business.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.backapp.domain.Todo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/api/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> get() {
        return todoService.findAll();
    }

    @PostMapping
    public void post(final Todo todo) {
        // TODO
    }

    @PutMapping
    public void put(final Todo todo) {
        // TODO
    }

    @DeleteMapping()
    public void delete() {
        // TODO
    }


}
