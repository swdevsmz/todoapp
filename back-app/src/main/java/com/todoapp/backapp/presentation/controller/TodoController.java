package com.todoapp.backapp.presentation.controller;

import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.backapp.model.Todo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(value = "/api")
public class TodoController {
    
    private final List<Todo> todos = Arrays.asList(
                                            new Todo(1L,"ごはん",false),
                                            new Todo(2L,"運動",true)
                                            );


    @GetMapping(value = "/todos")
    public List<Todo> get(){
        return todos;
    }

    @PostMapping("/todos")
    public void post(final Todo todo) {
        todos.add(todo);
    }
    
    @PutMapping("/todos")
    public void put(final Todo todo){
        todos.stream().findFirst(x -> x.getId().equals(todo.getId()))        
    }



}
