package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Categories;
import com.example.demo.models.dto.request.CategoryRequest;
import com.example.demo.models.dto.response.CategoryResponse;
import com.example.demo.repositories.CategoriesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriesService {
    private CategoriesRepository categoriesRepository;

    public List<Categories> getAll() {
        return categoriesRepository.findAll();
    }

    public List<CategoryResponse> getAllDTO() {
        List<Categories> categories = categoriesRepository.findAll();
        return categories.stream()
                .map(this::mapEntityToResponseDTO)
                .collect(Collectors.toList());
    }

    public Categories getById(Integer id) {
        return categoriesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categories is not found"));
    }

    public Categories create(CategoryRequest categoryRequest) {
        Categories newCategoy = new Categories();
        newCategoy.setName(categoryRequest.getName());

        return categoriesRepository.save(newCategoy);
    }

    public Categories update(Integer id, CategoryRequest categoryRequest) {
        Categories existingCategory = categoriesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categories is not found"));

        existingCategory.setName(categoryRequest.getName());

        return categoriesRepository.save(existingCategory);
    }

    private CategoryResponse mapEntityToResponseDTO(Categories category) {
        CategoryResponse responseDTO = new CategoryResponse();
        responseDTO.setId(category.getId());
        responseDTO.setName(category.getName());
        return responseDTO;
    }

    public void delete(Integer id) {
        if (!categoriesRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categories id is not found");
        }
        categoriesRepository.deleteById(id);
        throw new ResponseStatusException(HttpStatus.ACCEPTED, "Categories has been deleted");
    }

}
