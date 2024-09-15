package com.todoapp.backapp.presentation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.backapp.business.TodoService;
import com.todoapp.backapp.persistance.entity.Todo;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(value = "/api/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> get() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Todo> findById(@PathVariable final Long id) {
        return todoService.findById(id);
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
