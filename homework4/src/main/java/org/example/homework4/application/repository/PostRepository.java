package org.example.homework4.application.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.homework4.application.models.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PostRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void savePost(Post post){
        entityManager.persist(post);
    }

    @Transactional
    public void deletePost(Long id){
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }

    @Transactional
    public void updatePost(Long postId, Post post){
        Post postFound = entityManager.find(Post.class, postId);

        postFound.setTitle(post.getTitle());
        postFound.setDescription(post.getDescription());

        entityManager.merge(postFound);
    }

    @Transactional
    public Post readPost(Long id){
        return entityManager.find(Post.class, id);
    }


}
