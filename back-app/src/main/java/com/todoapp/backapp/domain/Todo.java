package com.todoapp.backapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Long id;
    private String summary;
    private Boolean done;
    private Date createdAt;
}
