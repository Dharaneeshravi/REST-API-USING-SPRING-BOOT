package com.Dharaneesh.REST.API.Review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/college/{collegeId}/review")
    public ResponseEntity<List<Review>> getReview(@PathVariable Long collegeId)
    {
        return new ResponseEntity<>(reviewService.getReview(collegeId), HttpStatus.OK);
    }

    @PostMapping("/college/{collegeId}/review")
    public ResponseEntity<String> createReview(@PathVariable Long collegeId, @RequestBody Review review)
    {
        boolean res= reviewService.createReview(collegeId,review);

        if(res)
        {
            return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/college/{collegeId}/review/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long collegeId,@PathVariable Long reviewId)
    {
        Review res=reviewService.getReviewById(collegeId,reviewId);

        if(res!=null)
        {
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/college/{collegeId}/review/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long collegeId,@PathVariable Long reviewId,@RequestBody Review review)
    {
        boolean res=reviewService.updateReviewById(collegeId,reviewId,review);

        if(res)
        {
            return new ResponseEntity<>("UPDATE SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/college/{collegeId}/review/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long collegeId,@PathVariable Long reviewId)
    {
        boolean res=reviewService.deleteReviewById(collegeId,reviewId);

        if(res)
        {
            return new ResponseEntity<>("DELETED SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }
}
