package com.practice.devLit.controller;

import com.practice.devLit.model.Posts;
import com.practice.devLit.model.Users;
import com.practice.devLit.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

    @Autowired
    private PostsRepository postsRepository;
    @GetMapping("/posts/{author}")
    public Iterable<Posts>  getPostsByAuthor(@PathVariable Users author)  {
        return postsRepository.findByAuthor(author);
    }

    @PostMapping("/save-posts")
    public Posts savePosts(Posts post){
        return postsRepository.save(post);
    }
}
