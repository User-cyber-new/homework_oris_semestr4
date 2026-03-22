package org.example.homework4.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private UserDto userDto;

    public PostDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
