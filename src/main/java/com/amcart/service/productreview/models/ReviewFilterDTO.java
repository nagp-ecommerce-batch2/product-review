package com.amcart.service.productreview.models;



public class ReviewFilterDTO {
	
	private String filterKey;
	private String filterValue;
    

    @Override
    public String toString() {
    	return "ReviewFilterDTO [filterKey=" + filterKey + ", filterValue=" + filterValue + "]";
    }


	public String getFilterKey() {
		return filterKey;
	}


	public void setFilterKey(String filterKey) {
		this.filterKey = filterKey;
	}


	public String getFilterValue() {
		return filterValue;
	}


	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

    
}
