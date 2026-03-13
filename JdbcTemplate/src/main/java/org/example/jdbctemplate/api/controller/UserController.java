package org.example.jdbctemplate.api.controller;

import lombok.AllArgsConstructor;
import org.example.jdbctemplate.api.dto.UserDto;
import org.example.jdbctemplate.application.mapper.UserMapper;
import org.example.jdbctemplate.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    @RequestMapping("save")
    public ResponseEntity<Void> save(@RequestBody UserDto userDto){
        if (userService.saveUser(UserMapper.toEntity(userDto))){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping
    @RequestMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        if (userService.deleteUser(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    @RequestMapping("get/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Integer id){
        UserDto userDto = UserMapper.userDto(userService.readUser(id));
        if (userDto!=null){
            return ResponseEntity.ok().body(userDto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping
    @RequestMapping("patch")
    public ResponseEntity<Void> get(@RequestBody UserDto userDto){
        if (userService.updateUser(UserMapper.toEntity(userDto))){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
