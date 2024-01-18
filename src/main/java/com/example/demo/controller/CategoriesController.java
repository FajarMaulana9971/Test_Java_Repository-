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

import com.example.demo.models.Categories;
import com.example.demo.models.dto.request.CategoryRequest;
import com.example.demo.models.dto.response.CategoryResponse;
import com.example.demo.services.CategoriesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    private CategoriesService categoriesService;

    @GetMapping
    public List<Categories> getALL() {
        return categoriesService.getAll();
    }

    @GetMapping("/dto")
    public List<CategoryResponse> getALLDTO() {
        return categoriesService.getAllDTO();
    }

    @GetMapping("/{id}")
    public Categories getById(@PathVariable Integer id) {
        return categoriesService.getById(id);
    }

    @PostMapping
    public Categories create(@RequestBody CategoryRequest categoryRequest) {
        return categoriesService.create(categoryRequest);
    }

    @PutMapping("/{id}")
    public Categories update(@PathVariable Integer id, @RequestBody CategoryRequest categoryRequest) {
        return categoriesService.update(id, categoryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoriesService.delete(id);
    }
}
