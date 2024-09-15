package com.todoapp.backapp.business.impl;

import com.todoapp.backapp.business.TodoService;
import com.todoapp.backapp.persistance.entity.Todo;
import com.todoapp.backapp.persistance.mapper.TodoMapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    @Override
    public List<Todo> findAll() {
        return todoMapper.findAll();
    }

    @Override
    public Optional<Todo> findById(final Long id) {
        return todoMapper.findById(id);
    }

    @Override
    public boolean create(final Todo todo) {
        return todoMapper.create(todo);
    }

    @Override
    public boolean update(final Todo todo) {
        return todoMapper.update(todo);
    }

    @Override
    public boolean delete(Todo todo) {
        return todoMapper.delete(todo);
    }

    @Override
    public Long countByDone() {
        return todoMapper.countByDone();
    }
}
