package com.ecommerce.productreview.db.repository;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.ecommerce.productreview.entity.Review;
import com.ecommerce.productreview.exception.AddItemException;
import com.ecommerce.productreview.models.ReviewDTO;
import com.ecommerce.productreview.models.ReviewFilterDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@Repository
public class ReviewDynamoDB {

    private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
    
    @Autowired
    private DynamoDbEnhancedClient dynamoDbenhancedClient;

    public  void addReview(ReviewDTO reviewDTO) {
        try {
            DynamoDbTable<Review> table = getTable();

            Review review = new Review(
            		reviewDTO.getProductId(),
            		reviewDTO.getUserId(),
            		reviewDTO.getComment(),
            		reviewDTO.getRating(),
            		reviewDTO.getTitle()
            		);

            System.err.println("adding review"+review.toString());
            table.putItem(review);
                
        } catch (Exception e) {
        	System.err.println(e);
            LOGGER.error(e.getMessage());
            LOGGER.error(e.getStackTrace().toString());
            LOGGER.error("Error while getting review from table %s", e.getMessage());
            throw new AddItemException();
        }
        return;

    }

    public List<ReviewDTO> getReviews() {
        List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
        try {

            DynamoDbTable<Review> table = getTable();
            
    
            Map<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
    
            AttributeValue pkPrefixAttr = AttributeValue.builder()
            .s("review_id:")
            .build();
    
    
            expressionAttributeValues.put(":pkPrefix", pkPrefixAttr);
    
            Expression expression = Expression.builder()
            .expression("begins_with(reviewId, :pkPrefix)")
            .expressionValues(expressionAttributeValues)
            .build();
    
            ScanEnhancedRequest enhancedRequest = ScanEnhancedRequest
            .builder()
            .build();
            
     
            Iterator<Review> results = table.scan(enhancedRequest).items().iterator();
            while(results.hasNext()) {
                ReviewDTO reviewDTO = new ReviewDTO();
                Review review = results.next();
                BeanUtils.copyProperties(review, reviewDTO);
                reviewDTOs.add(reviewDTO);
            }
    
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return reviewDTOs;
    } 

    public List<ReviewDTO> searchReviews(ReviewFilterDTO reviewFilterDTO) {
        List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
        try {

            DynamoDbTable<Review> table = getTable();
            
    
            Map<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
            AttributeValue pkPrefixAttr = AttributeValue.builder()
            .s(reviewFilterDTO.getFilterValue())
            .build();
            
    
            expressionAttributeValues.put(":pkPrefix", pkPrefixAttr);
            String fieldExpression = "begins_with(" + reviewFilterDTO.getFilterKey()+ ", :pkPrefix)";
            Expression expression = Expression.builder()
            .expression(fieldExpression)
            .expressionValues(expressionAttributeValues)
            .build();
    
            ScanEnhancedRequest enhancedRequest = ScanEnhancedRequest
            .builder()
            .filterExpression(expression)
            .build();
            
            
            Iterator<Review> results = table.scan(enhancedRequest).items().iterator();
            while(results.hasNext()) {
                ReviewDTO reviewDTO = new ReviewDTO();
                Review review = results.next();
                BeanUtils.copyProperties(review, reviewDTO);
                reviewDTOs.add(reviewDTO);
            }
    
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return reviewDTOs;
    } 



    private DynamoDbTable<Review> getTable() {
        DynamoDbTable<Review> reviewTable = dynamoDbenhancedClient.table("review", TableSchema.fromBean(Review.class));
        return reviewTable;
    }


}

