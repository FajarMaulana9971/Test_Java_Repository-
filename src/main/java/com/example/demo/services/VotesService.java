package com.example.demo.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Votes;
import com.example.demo.repositories.VotesRepositories;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VotesService {
    private VotesRepositories votesRepositories;

    public List<Votes> getALL() {
        return votesRepositories.findAll();
    }

    public Votes getById(Integer id) {
        return votesRepositories.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Votes id not found"));
    }
}
