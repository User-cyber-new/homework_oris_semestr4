package org.example.jdbctemplate.application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserEntity {
    private Integer id;
    private Integer age;
    private String fullname;
}
