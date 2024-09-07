package com.todoapp.backapp.presentation.controller;

import java.util.Arrays;
import java.util.List;

import com.todoapp.backapp.business.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.todoapp.backapp.domain.Todo;


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
    public boolean post(@RequestBody final Todo todo) {
        return todoService.create(todo);
    }

    @PutMapping
    public boolean put(@RequestBody final Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping()
    public boolean delete(@RequestBody final Todo todo) {
        return todoService.delete(todo);
    }

    @GetMapping(path = "/count")
    public Long count() {
        return todoService.countByDone();
    }
}
