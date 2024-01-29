package com.example.XSS.controller;


import com.example.XSS.model.Post;
import com.example.XSS.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class PostController {

    @Autowired
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        List<Post> posts = postService.findAll();
        return posts;
    }

    @PostMapping("/post")
    public void createPost(@RequestBody Post post){

        postService.save(post);
        System.out.println("JS planted successfully");
    }



}
