package com.example.linky.main.model.review;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository {
    List<ReviewEntity> findAllByRdt();
}