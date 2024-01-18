package com.example.demo.models.dto.request;

import com.example.demo.models.StatusEnum;
import com.example.demo.models.TypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleRequest {
    private String title;
    private String slug;
    private String body;
    private String banner;
    private String image;
    private Integer counter;
    private TypeEnum type;
    private StatusEnum status;
    private boolean isSlideShow;
}
