package org.example.homework5.api.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private String name;
    private String email;
    private String password;
}
