package com.ecommerce.productreview.entity;

import java.util.Date;
import java.util.UUID;


import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


@DynamoDbBean
@NoArgsConstructor
public class Review {

	private String reviewId;
	private String productId;
	private String userId;
    private String comment;
    private double rating;
    private String reviewDate;
    
    public Review(String productId, String userId, String comment, int rating) {
    	this.reviewId = this.generateReviewId();
        this.comment = comment;
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.reviewDate = new Date().toString();
    }

    
    @DynamoDbPartitionKey
    @DynamoDbAttribute(value="reviewId")
    public String getReviewId() {
        return this.reviewId;
    }
    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }
    
    @DynamoDbAttribute("comment")
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    @DynamoDbAttribute("userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @DynamoDbAttribute("productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    @DynamoDbAttribute("rating")
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    @DynamoDbAttribute("reviewDate")
    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review [productId=" + productId + ", userId=" + userId + ", comment=" + comment + "rating=" + 
        		rating   + "]";
    }
    
    private String generateReviewId(){
        return "review_id:" + UUID.randomUUID().toString();
    }

    

}
