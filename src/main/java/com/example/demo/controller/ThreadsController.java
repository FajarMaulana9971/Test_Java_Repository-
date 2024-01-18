package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Threads;
import com.example.demo.models.dto.request.ThreadsRequest;
import com.example.demo.services.ThreadsService;

import lombok.AllArgsConstructor;

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

    @PostMapping
    public Threads createDTO(@RequestBody ThreadsRequest threadsRequest) {
        return threadsService.create(threadsRequest);
    }
}
