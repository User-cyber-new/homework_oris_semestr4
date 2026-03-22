package org.example.homework4.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.homework4.api.dto.UserDto;
import org.example.homework4.api.mapper.UserMapper;
import org.example.homework4.application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<Void> saveUserDto(@RequestBody UserDto userDto){
        log.info("имя: " + userDto.getName());
        userService.saveUser(UserMapper.toModelCreate(userDto));
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @RequestMapping("/patch/{user-id}")
    public ResponseEntity<Void> updateUserDto(@PathVariable(name = "user-id") Long userId, @RequestBody UserDto userDto){
        userService.updateUser(userId, UserMapper.toModelUpdate(userId, userDto));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @RequestMapping("/delete/{user-id}")
    public ResponseEntity<Void> deleteUserDto(@PathVariable(name = "user-id") Long userId){
        userService.deleteUser(userId);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @RequestMapping("/get/{user-id}")
    public ResponseEntity<UserDto> getUserDto(@PathVariable(name = "user-id") Long userId){
        UserDto userDto = UserMapper.toDtoRead(userService.readUser(userId));

        return ResponseEntity.ok().body(userDto);
    }

}
