package com.amcart.service.productreview.services;



import java.util.List;

import com.amcart.service.productreview.models.ReviewDTO;
import com.amcart.service.productreview.models.ReviewFilterDTO;

public interface IReviewService {
    public void addReview(ReviewDTO reviewDTO);

    public List<ReviewDTO> getReviews();
    public List<ReviewDTO> searchReviews(ReviewFilterDTO reviewDTO);
}
