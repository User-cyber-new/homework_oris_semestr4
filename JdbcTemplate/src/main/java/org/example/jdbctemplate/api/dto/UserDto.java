package org.example.jdbctemplate.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
    private Integer id;
    private Integer age;
    private String fullname;

}
