package com.todoapp.backapp.persistance.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.todoapp.backapp.persistance.entity.Todo;

@Mapper
public interface TodoMapper {
    
    List<Todo> findAll();

    Optional<Todo> findById(Long id);

    boolean create(Todo todo);

    @Update("UPDATE todo SET summary = #{summary}, done = #{done}, created_at = #{createdAt} WHERE id = #{id}")
    boolean update(Todo todo);

    @Delete("DELETE FROM todo WHERE id = #{id}")
    boolean delete(Todo todo);

    @Select("SELECT COUNT(*) FROM todo WHERE done = true")
    Long countByDone();
}
