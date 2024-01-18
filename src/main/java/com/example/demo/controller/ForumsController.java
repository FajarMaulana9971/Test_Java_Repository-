package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Forums;
import com.example.demo.services.ForumsServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/forums")
public class ForumsController {
    private ForumsServices forumsServices;

    @GetMapping
    public List<Forums> getALL() {
        return forumsServices.getALL();
    }

    @GetMapping("/{id}")
    public Forums getById(@PathVariable Integer id) {
        return forumsServices.getById(id);
    }
}
