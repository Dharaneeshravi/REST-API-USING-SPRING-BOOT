package com.Dharaneesh.REST.API.Review.ReviewServiceImp;

import com.Dharaneesh.REST.API.Review.ReviewRepository;
import com.Dharaneesh.REST.API.Review.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceimp implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceimp(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
