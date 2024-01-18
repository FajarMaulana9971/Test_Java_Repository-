package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Forums;
import com.example.demo.models.Threads;
import com.example.demo.services.ThreadsService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/threads")
public class ThreadsController {
    private ThreadsService threadsService;

    @GetMapping
    public List<Threads> getALL() {
        return threadsService.getALL();
    }

    @GetMapping("/{id}")
    public Threads getById(@PathVariable Integer id) {
        return threadsService.getById(id);
    }
}
