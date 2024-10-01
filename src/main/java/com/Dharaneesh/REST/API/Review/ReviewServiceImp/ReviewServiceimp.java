package com.Dharaneesh.REST.API.Review.ReviewServiceImp;

import com.Dharaneesh.REST.API.College.College;
import com.Dharaneesh.REST.API.College.CollegeService;
import com.Dharaneesh.REST.API.Review.Review;
import com.Dharaneesh.REST.API.Review.ReviewRepository;
import com.Dharaneesh.REST.API.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceimp implements ReviewService {

    private final ReviewRepository reviewRepository;
    private CollegeService collegeService;

    public ReviewServiceimp(ReviewRepository reviewRepository, CollegeService collegeService) {
        this.reviewRepository = reviewRepository;
        this.collegeService=collegeService;
    }

    @Override
    public List<Review> getReview(Long collegeId) {
        return reviewRepository.findByCollegeId(collegeId);
    }

    @Override
    public boolean createReview(Long collegeId, Review review) {

        College college=collegeService.getCollegeById(collegeId);

        if(college!=null)
        {
            review.setCollege(college);
            reviewRepository.save(review);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Review getReviewById(Long collegeId, Long reviewId) {

        List<Review> reviews=reviewRepository.findByCollegeId(collegeId);

        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReviewById(Long collegeId, Long reviewId, Review review) {

        if(collegeService.getCollegeById(collegeId)!=null)
        {
            review.setCollege(collegeService.getCollegeById(collegeId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteReviewById(Long collegeId, Long reviewId) {

        if(collegeService.getCollegeById(collegeId)!=null && reviewRepository.existsById(reviewId))
        {
            Review review=reviewRepository.findById(reviewId).orElse(null);
            College college=review.getCollege();
            college.getReviewList().remove(college);
            college.setReviewList(null);
            collegeService.updateCollegeById(collegeId,college);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        else
        {
            return false;
        }
    }
}
