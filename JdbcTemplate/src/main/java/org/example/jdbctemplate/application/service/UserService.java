package org.example.jdbctemplate.application.service;

import lombok.AllArgsConstructor;
import org.example.jdbctemplate.application.entities.UserEntity;
import org.example.jdbctemplate.application.repository.impls.UserRepositoryDB;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserService {
    private UserRepositoryDB userRepositoryDB;

    public boolean saveUser(UserEntity userEntity){
        return userRepositoryDB.create(userEntity);
    }

    public boolean updateUser(UserEntity userEntity){
        return userRepositoryDB.update(userEntity);
    }

    public boolean deleteUser(Integer id){
        return userRepositoryDB.delete(id);
    }

    public UserEntity readUser(Integer id){
        return userRepositoryDB.read(id);
    }

    public List<UserEntity> readAll(){
        return userRepositoryDB.getAll();
    }

}
