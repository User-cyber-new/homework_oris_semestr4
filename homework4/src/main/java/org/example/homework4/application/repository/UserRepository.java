package org.example.homework4.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.homework4.application.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveUser(User user){
        entityManager.persist(user);
    }

    @Transactional
    public void updateUser(Long id, User user){
        User userFound = entityManager.find(User.class, id);

        userFound.setName(user.getName());
        userFound.setAge(user.getAge());
        userFound.setStatus(user.getStatus());

        if (user.getPosts()!=null){
            userFound.setPosts(user.getPosts());
        }


        entityManager.merge(userFound);
    }

    @Transactional(readOnly = true)
    public User readUser(Long id){
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void removeUser(Long id){
        User removeUser = entityManager.find(User.class, id);
        entityManager.remove(removeUser);
    }

}
