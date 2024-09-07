package com.todoapp.backapp.business.impl;

import com.todoapp.backapp.business.TodoService;
import com.todoapp.backapp.domain.Todo;
import com.todoapp.backapp.repository.mapper.TodoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    @Override
    public List<Todo> findAll() {
        return todoMapper.findAll();
    }
}
