package com.Dharaneesh.REST.API.Review;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
