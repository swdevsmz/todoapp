package com.todoapp.backapp.persistance.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.todoapp.backapp.persistance.entity.Todo;

@Mapper
public interface TodoMapper {
    
    List<Todo> findAll();

    Optional<Todo> findById(Long id);

    boolean create(Todo todo);

    boolean update(Todo todo);

    boolean delete(Todo todo);

    Long countByDone();
}
