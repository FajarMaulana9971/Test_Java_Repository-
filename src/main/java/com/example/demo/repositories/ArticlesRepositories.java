package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Articles;

@Repository
public interface ArticlesRepositories extends JpaRepository<Articles, Integer> {

}
