package org.example.homework4.api.mapper;

import org.example.homework4.api.dto.PostDto;
import org.example.homework4.application.models.Post;

public class PostMapper {

    public static Post toModelCreate(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());

        return post;
    }

    public static PostDto toDtoRead(Post post){
        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setUserDto(UserMapper.toDtoRead(post.getUser()));

        return postDto;
    }

}
