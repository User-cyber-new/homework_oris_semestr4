package org.example.homework4.api.mapper;

import org.example.homework4.api.dto.PostDto;
import org.example.homework4.api.dto.UserDto;
import org.example.homework4.application.models.Post;
import org.example.homework4.application.models.User;

import java.util.stream.Collectors;


public class UserMapper {
    public static User toModelCreate(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setStatus(userDto.getStatus());
        if (userDto.getPosts() != null) {
            for (PostDto postDto: userDto.getPosts()){
                Post post = new Post();
                post.setTitle(postDto.getTitle());
                post.setDescription(postDto.getDescription());

                user.addPost(post);
            }
        }

        return user;
    }

    public static User toModelUpdate(Long id, UserDto userDto){
        User user = new User();
        user.setId(id);
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setStatus(userDto.getStatus());
        if (userDto.getPosts()!=null){
            for (PostDto postDto: userDto.getPosts()){
                Post post = new Post();
                post.setTitle(postDto.getTitle());
                post.setDescription(postDto.getDescription());

                user.addPost(post);
            }
        }
        return user;
    }

    public static UserDto toDtoRead(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setStatus(user.getStatus());

        userDto.setPosts(user.getPosts().stream().map(post -> new PostDto(post.getId(), post.getTitle(), post.getDescription())).collect(Collectors.toSet()));

        return userDto;
    }
}
