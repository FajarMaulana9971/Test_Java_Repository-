package com.example.demo.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Threads;
import com.example.demo.repositories.ThreadsRepositories;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ThreadsService {
    private ThreadsRepositories threadsRepositories;

    public List<Threads> getALL() {
        return threadsRepositories.findAll();
    }

    public Threads getById(Integer id) {
        return threadsRepositories.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Threads id is not found"));
    }
}
