package com.amcart.service.productreview.models;

import java.util.Date;


public class ReviewDTO {
	
	private String reviewId;
	private String productId;
	private String userId;
    private String comment;
    private double rating;
    private String reviewDate;
    private String title;
    
    
    public ReviewDTO() {
    }

    public ReviewDTO(String reviewId, String productId, String userId, String comment, double rating, String reviewDate, String title) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.title = title;
    }

    public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


    @Override
    public String toString() {
    	return "ReviewDTO [productId=" + productId + ", userId=" + userId + ", comment=" + comment + "rating=" + 
        		rating  + "]";
    }
    
}

