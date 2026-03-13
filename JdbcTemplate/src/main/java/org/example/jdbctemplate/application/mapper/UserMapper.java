package org.example.jdbctemplate.application.mapper;

import org.example.jdbctemplate.api.dto.UserDto;
import org.example.jdbctemplate.application.entities.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserDto userDto){
        return new UserEntity(
                userDto.getId(),
                userDto.getAge(),
                userDto.getFullname()
        );
    }

    public static UserDto userDto(UserEntity userEntity){
        return new UserDto(
                userEntity.getId(),
                userEntity.getAge(),
                userEntity.getFullname());
    }

}
