package com.example.demo.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Forums;
import com.example.demo.repositories.ForumsRepositories;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ForumsServices {
    private ForumsRepositories forumsRepositories;

    public List<Forums> getALL() {
        return forumsRepositories.findAll();
    }

    public Forums getById(Integer id) {
        return forumsRepositories.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Forums id not found"));
    }
}
