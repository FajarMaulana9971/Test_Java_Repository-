package com.example.demo.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Posts;
import com.example.demo.repositories.PostsRepositories;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepositories postsRepositories;

    public List<Posts> getALL() {
        return postsRepositories.findAll();
    }

    public Posts getById(Integer id) {
        return postsRepositories.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Posts id not found"));
    }
}
