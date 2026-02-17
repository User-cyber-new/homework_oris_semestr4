package org.oris;

import org.oris.entities.UserEntity;
import org.oris.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.oris");

        UserService userService = applicationContext.getBean(UserService.class);

        // перед пушем создал UserEntity(1, "user1")
        //userService.createUser(new UserEntity(1, "user1"));
        UserEntity userEntity = userService.findUserById(1);
        //userService.updateUserById(1, "user1Updated");
        System.out.println(userEntity);

        //userService.deleteUserById(1);
    }
}