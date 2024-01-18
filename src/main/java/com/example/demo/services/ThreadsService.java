package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Forums;
import com.example.demo.models.Threads;
import com.example.demo.models.dto.request.ThreadsRequest;
import com.example.demo.repositories.ThreadsRepositories;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ThreadsService {
    private ThreadsRepositories threadsRepositories;

    // without dto
    public List<Threads> getALL() {
        return threadsRepositories.findAll();
    }

    public Threads getById(Integer id) {
        return threadsRepositories.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Threads id is not found"));
    }
    // without dto end

    // public Threads create(ThreadsRequest threadsRequest) {
    // Threads newThreads = new Threads();
    // newThreads.setTitle(threadsRequest.getTitle());
    // newThreads.setSlug(threadsRequest.getSlug());
    // newThreads.setCounter(threadsRequest.getCounter());
    // newThreads.setCreatedAt(LocalDateTime.now());
    // newThreads.setUpdatedAt(LocalDateTime.now());

    // return threadsRepositories.save(newThreads);
    // }

    public Threads create(ThreadsRequest threadsRequest) {
        Threads newThreads = new Threads();
        newThreads.setTitle(threadsRequest.getTitle());
        newThreads.setSlug(threadsRequest.getSlug());
        newThreads.setCounter(threadsRequest.getCounter());
        newThreads.setCreatedAt(LocalDateTime.now());
        newThreads.setUpdatedAt(LocalDateTime.now());

        Forums forums = new Forums();
        newThreads.setForums(forums);

        return threadsRepositories.save(newThreads);
    }
}
