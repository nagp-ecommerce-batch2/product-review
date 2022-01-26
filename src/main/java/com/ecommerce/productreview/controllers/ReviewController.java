package com.ecommerce.productreview.controllers;
import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.annotation.Resource;

import com.ecommerce.productreview.exception.InternalServerException;
import com.ecommerce.productreview.models.ReviewDTO;
import com.ecommerce.productreview.models.ReviewFilterDTO;
import com.ecommerce.productreview.services.impl.ReviewService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/reviews")
public class ReviewController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    @Resource
    private ReviewService reviewService;

    @PostMapping("/")
    public void addReview(@RequestBody ReviewDTO reviewDTO) {
    	System.err.println("adding review");
      LOGGER.info("Adding New Review to the table\n");
      try {
    	  reviewService.addReview(reviewDTO);
          return;
      } catch (Exception e) {
        System.err.println(e.getMessage());
        System.err.println(e.getStackTrace());
      }
      throw new InternalServerException();
    }
    
    @PostMapping("/search")
    public List<ReviewDTO> searchReviews(@RequestBody ReviewFilterDTO reviewFilterDTO) {
    	System.err.println("searching reviews");
      try {
    	  return reviewService.searchReviews(reviewFilterDTO);
      } catch (Exception e) {
        System.err.println(e.getMessage());
        System.err.println(e.getStackTrace());
      }
      throw new InternalServerException();
    }

    @GetMapping("/")
    public List<ReviewDTO> getReviews() {
      LOGGER.info("Getting All Reviews from the table\n");
      try {

          return reviewService.getReviews();
      
        } catch (Exception e) {
      
          System.err.println(e.getMessage());
        System.err.println(e.getStackTrace());
      
      }
      
      throw new InternalServerException();
    }
  
  
}
