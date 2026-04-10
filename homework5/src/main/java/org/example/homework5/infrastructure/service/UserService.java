package org.example.homework5.infrastructure.service;

import lombok.AllArgsConstructor;
import org.example.homework5.infrastructure.persistence.entity.UserEntity;
import org.example.homework5.infrastructure.persistence.entity.UserRole;
import org.example.homework5.infrastructure.persistence.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(String email, String name, String password) {
        userRepository.saveUser(email, name, passwordEncoder.encode(password), UserRole.USER.name());
    }

    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email).get();
    }
}
