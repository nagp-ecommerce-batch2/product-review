package com.ecommerce.productreview.services;



import java.util.List;

import com.ecommerce.productreview.models.ReviewDTO;
import com.ecommerce.productreview.models.ReviewFilterDTO;

public interface IReviewService {
    public void addReview(ReviewDTO reviewDTO);

    public List<ReviewDTO> getReviews();
    public List<ReviewDTO> searchReviews(ReviewFilterDTO reviewDTO);
}
