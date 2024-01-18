package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Articles;
import com.example.demo.models.Categories;
import com.example.demo.models.dto.request.ArticleRequest;
import com.example.demo.models.dto.response.ArticleResponse;
import com.example.demo.repositories.ArticlesRepositories;
import com.example.demo.repositories.CategoriesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticlesServices {
    private ArticlesRepositories articlesRepositories;
    private CategoriesRepository categoriesRepository;

    public List<Articles> getALL() {
        return articlesRepositories.findAll();
    }

    public List<ArticleResponse> getALLDTO() {
        List<Articles> articles = articlesRepositories.findAll();
        return articles.stream()
                .map(article -> {
                    ArticleResponse response = new ArticleResponse();
                    response.setId(article.getId());
                    response.setTitle(article.getTitle());
                    response.setSlug(article.getSlug());
                    response.setBody(article.getBody());
                    response.setBanner(article.getBanner());
                    response.setImage(article.getImage());
                    response.setType(article.getType());
                    response.setStatus(article.getStatus());
                    response.setSlideShow(article.isSlideShow());
                    response.setCounter(article.getCounter());
                    response.setCreatedAt(article.getCreatedAt());
                    response.setUpDateTime(article.getUpdatedAt());
                    // response.setCategories(article.getCategories().stream().map(Category::getName).collect(Collectors.toList()));
                    return response;
                })
                .collect(Collectors.toList());
    }

    public Articles getById(Integer id) {
        return articlesRepositories.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article id is not found"));
    }

    public Articles create(ArticleRequest articleRequest) {
        Articles newArticle = new Articles();
        newArticle.setTitle(articleRequest.getTitle());
        newArticle.setSlug(articleRequest.getSlug());
        newArticle.setBody(articleRequest.getBody());
        newArticle.setBanner(articleRequest.getBanner());
        newArticle.setImage(articleRequest.getImage());
        newArticle.setCounter(articleRequest.getCounter());
        newArticle.setType(articleRequest.getType());
        newArticle.setStatus(articleRequest.getStatus());
        newArticle.setSlideShow(articleRequest.isSlideShow());
        newArticle.setCreatedAt(LocalDateTime.now());
        newArticle.setUpdatedAt(LocalDateTime.now());

        return articlesRepositories.save(newArticle);
    }

}