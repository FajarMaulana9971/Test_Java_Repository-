package com.example.demo.models.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreadsRequest {
    private String title;
    private String slug;
    private Integer counter;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
