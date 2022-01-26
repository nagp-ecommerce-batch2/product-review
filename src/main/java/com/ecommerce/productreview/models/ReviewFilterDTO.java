package com.ecommerce.productreview.models;

public class ReviewFilterDTO {
	
	private String filterKey;
	private String filterValue;
    

    @Override
    public String toString() {
    	return "ReviewFilterDTO [filterKey=" + filterKey + ", filterValue=" + filterValue + "]";
    }

}
