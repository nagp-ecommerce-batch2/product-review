package com.ecommerce.productreview.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewFilterDTO {
	
	private String filterKey;
	private String filterValue;
    

    @Override
    public String toString() {
    	return "ReviewFilterDTO [filterKey=" + filterKey + ", filterValue=" + filterValue + "]";
    }

}
