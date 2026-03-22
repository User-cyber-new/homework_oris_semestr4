package org.example.homework4.application.service;

import lombok.AllArgsConstructor;
import org.example.homework4.application.models.Post;
import org.example.homework4.application.models.User;
import org.example.homework4.application.repository.PostRepository;
import org.example.homework4.application.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public void savePost(Long userId, Post post){
        User user = userRepository.readUser(userId);
        user.addPost(post);
        userRepository.updateUser(userId, user);
    }

    public void deletePost(Long id){
        postRepository.deletePost(id);
    }

    public void updatePost(Long postId, Post post){
        postRepository.updatePost(postId, post);
    }

    public Post readPost(Long id){
        return postRepository.readPost(id);
    }

}
