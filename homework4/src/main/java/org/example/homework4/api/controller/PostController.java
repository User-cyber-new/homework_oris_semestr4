package org.example.homework4.api.controller;

import lombok.AllArgsConstructor;
import org.example.homework4.api.dto.PostDto;
import org.example.homework4.api.mapper.PostMapper;
import org.example.homework4.application.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{user-id}/post")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<Void> savePost(@PathVariable(name = "user-id") Long userId, @RequestBody PostDto postDto){

        postService.savePost(userId, PostMapper.toModelCreate(postDto));

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @RequestMapping("/get/{post-id}")
    public ResponseEntity<PostDto> getPost(@PathVariable(name = "post-id") Long postId){
        PostDto postDto = PostMapper.toDtoRead(postService.readPost(postId));

        return ResponseEntity.ok().body(postDto);
    }

    @DeleteMapping
    @RequestMapping("/delete/{post-id}")
    public ResponseEntity<Void> deletePost(@PathVariable(name = "post-id") Long postId){
       postService.deletePost(postId);

       return ResponseEntity.ok().build();
    }

    @PatchMapping
    @RequestMapping("/patch/{post-id}")
    public ResponseEntity<Void> patchPost(@PathVariable(name = "post-id") Long postId, @RequestBody PostDto postDto){
        postService.updatePost(postId, PostMapper.toModelCreate(postDto));

        return ResponseEntity.ok().build();
    }

}
