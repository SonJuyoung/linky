package com.example.linky.main.model.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired private ReviewRepository reviewRepository;

    public void delExcessItems() {
        reviewRepository.deleteOldReview();
    }
}
