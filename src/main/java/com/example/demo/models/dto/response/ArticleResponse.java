package com.example.demo.models.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.models.StatusEnum;
import com.example.demo.models.TypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleResponse {
    private Integer id;
    private String title;
    private String slug;
    private String body;
    private String banner;
    private String image;
    private TypeEnum type;
    private StatusEnum status;
    private boolean isSlideShow;
    private Integer counter;
    private LocalDateTime createdAt;
    private LocalDateTime upDateTime;
    private List<String> categories;
}
