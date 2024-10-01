package com.Dharaneesh.REST.API.Review;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReviewService {

    List<Review> getReview(Long collegeId);
    boolean createReview(Long collegeId,Review review);
    Review  getReviewById(Long collegeId,Long reviewId);

    boolean updateReviewById(Long collegeId, Long reviewId, Review review);

    boolean deleteReviewById(Long collegeId, Long reviewId);
}
