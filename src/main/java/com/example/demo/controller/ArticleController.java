package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Articles;
import com.example.demo.models.dto.request.ArticleRequest;
import com.example.demo.models.dto.response.ArticleResponse;
import com.example.demo.services.ArticlesServices;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private ArticlesServices articlesServices;

    @GetMapping
    public List<ArticleResponse> getALL() {
        return articlesServices.getALLDTO();
    }

    @GetMapping("/{id}")
    public Articles getById(@PathVariable Integer id) {
        return articlesServices.getById(id);
    }

    @PostMapping
    public Articles createDTO(@RequestBody ArticleRequest articleRequest) {
        return articlesServices.create(articleRequest);
    }

    @PutMapping("/{id}")
    public Articles updateDTO(@PathVariable Integer id, @RequestBody ArticleRequest articleRequest) {
        return articlesServices.updateArticle(id, articleRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        articlesServices.deleteArticle(id);
    }
}
