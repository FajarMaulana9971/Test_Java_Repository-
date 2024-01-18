package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Posts;
import com.example.demo.models.Threads;
import com.example.demo.services.PostsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/Posts")
@RestController
public class PostsController {
    private PostsService postsService;

    @GetMapping
    public List<Posts> getALL() {
        return postsService.getALL();
    }

    @GetMapping("/{id}")
    public Posts getById(@PathVariable Integer id) {
        return postsService.getById(id);
    }
}
