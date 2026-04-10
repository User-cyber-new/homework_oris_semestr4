package org.example.homework5.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.homework5.api.dto.UserDto;
import org.example.homework5.infrastructure.persistence.entity.UserEntity;
import org.example.homework5.infrastructure.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute UserDto userDto, Model model) {
        log.info(userDto.getEmail());
        log.info(userDto.getPassword());
        log.info(userDto.getName());
        userService.registerUser(
                userDto.getEmail(),
                userDto.getName(),
                userDto.getPassword()
        );
        model.addAttribute("user", userDto);
        return "success";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @GetMapping("/enter")
    public String getEnterForm() {
        return "enter";
    }

    @PostMapping("/enter")
    public String toEnter(@ModelAttribute UserDto userDto, Model model) {

        model.addAttribute("user", userDto);
        return "success";
    }

    @GetMapping("/success")
    public String success(Model model, Principal principal) {

        UserEntity userEntity = userService.findUserByEmail(principal.getName());
        UserDto userDto = UserDto.builder()
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .name(userEntity.getName())
                .build();

        model.addAttribute("user", userDto);
        return "success";
    }
}
