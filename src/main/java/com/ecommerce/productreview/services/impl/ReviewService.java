package com.ecommerce.productreview.services.impl;


import java.util.List;

import com.ecommerce.productreview.services.IReviewService;
import com.ecommerce.productreview.db.repository.ReviewDynamoDB;
import com.ecommerce.productreview.models.ReviewDTO;
import com.ecommerce.productreview.models.ReviewFilterDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
