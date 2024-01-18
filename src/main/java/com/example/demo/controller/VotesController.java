package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Posts;
import com.example.demo.models.Votes;
import com.example.demo.services.VotesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/votes")
public class VotesController {
    private VotesService votesService;

    @GetMapping
    public List<Votes> getALL() {
        return votesService.getALL();
    }

    @GetMapping("/{id}")
    public Votes getById(@PathVariable Integer id) {
        return votesService.getById(id);
    }
}
