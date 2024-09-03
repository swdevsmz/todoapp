package com.todoapp.backapp.presentation.controller;

import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.backapp.model.Todo;

@RestController
@RequestMapping(value = "/api")
public class TodoController {
    
    private final List<Todo> todos = Arrays.asList(
                                            new Todo(1L,"ごはん",false),
                                            new Todo(2L,"運動",false)
                                            );


    @GetMapping(value = "/todos")
    public List<Todo> todos(){
        return todos;
    }


}
