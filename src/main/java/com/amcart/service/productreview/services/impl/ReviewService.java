package com.amcart.service.productreview.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amcart.service.productreview.db.repository.ReviewDynamoDB;
import com.amcart.service.productreview.models.ReviewDTO;
import com.amcart.service.productreview.models.ReviewFilterDTO;
import com.amcart.service.productreview.services.IReviewService;

@Service
public class ReviewService implements IReviewService {

    @Autowired
	ReviewDynamoDB reviewStoreDynamoDB;

    @Override
    public void addReview(ReviewDTO reviewDTO) {
    	reviewStoreDynamoDB.addReview(reviewDTO);
    }
    
    @Override
    public List<ReviewDTO> getReviews() {
        return reviewStoreDynamoDB.getReviews();
    }
    
    @Override
    public List<ReviewDTO> searchReviews(ReviewFilterDTO reviewFilterDTO) {
        return reviewStoreDynamoDB.searchReviews(reviewFilterDTO);
    }
}
