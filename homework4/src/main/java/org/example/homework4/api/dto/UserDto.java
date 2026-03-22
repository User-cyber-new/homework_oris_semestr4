package org.example.homework4.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.homework4.application.models.Status;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private Integer age;
    private Status status;
    private Set<PostDto> posts = new HashSet<>();
}
