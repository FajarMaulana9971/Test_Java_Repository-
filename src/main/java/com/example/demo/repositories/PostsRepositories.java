package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Posts;

@Repository
public interface PostsRepositories extends JpaRepository<Posts, Integer> {

}
