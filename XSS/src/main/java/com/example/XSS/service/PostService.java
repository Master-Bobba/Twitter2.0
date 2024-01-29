package com.example.XSS.service;

import com.example.XSS.model.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    void save(Post post);
}
