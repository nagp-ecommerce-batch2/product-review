package com.amcart.service.productreview.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
	
	private String reviewId;
	private String productId;
	private String userId;
    private String comment;
    private double rating;
    private String reviewDate;
    private String title;
    

    @Override
    public String toString() {
    	return "ReviewDTO [productId=" + productId + ", userId=" + userId + ", comment=" + comment + "rating=" + 
        		rating  + "]";
    }
    
}

