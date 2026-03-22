package org.example.homework4.application.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.homework4.application.models.Post;
import org.example.homework4.application.models.User;
import org.example.homework4.application.repository.UserRepository;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void saveUser(User user){
        log.info("ИМЯ: " + user.getName());

        userRepository.saveUser(user);
    }

    public User readUser(Long id){
        return userRepository.readUser(id);
    }

    public void deleteUser(Long id){
        userRepository.removeUser(id);
    }

    public void updateUser(Long id, User user){
        userRepository.updateUser(id, user);
    }

}