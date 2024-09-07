package com.todoapp.backapp.repository.mapper;

import com.todoapp.backapp.domain.Todo;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TodoMapper {

    @Select("SELECT id, summary, done, created_at FROM todo WHERE id = #{id}")
    Optional<Todo> findById(Long id);

    @Select("SELECT id, summary, done, created_at FROM todo")
    List<Todo> findAll();

    @Insert("INSERT INTO todo (summary, done, created_at) VALUES (#{summary}, #{done}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean create(Todo todo);

    @Update("UPDATE todo SET summary = #{summary}, done = #{done}, created_at = #{createdAt} WHERE id = #{id}")
    boolean update(Todo todo);

    @Delete("DELETE FROM todo WHERE id = #{id}")
    boolean delete(Todo todo);

    @Select("SELECT COUNT(*) FROM todo WHERE done = true")
    Long countByDone();
}