package org.oris.service;

import org.oris.dao.UserDao;
import org.oris.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public void createUser(UserEntity user){
        userDao.createUser(user);
    }

    public UserEntity findUserById(int id){
        return userDao.findUserById(id);
    }

    public void updateUserById(int id, String name){
        userDao.updateUserById(id, name);
    }

    public void deleteUserById(int id){
        userDao.deleteUserById(id);
    }
}
