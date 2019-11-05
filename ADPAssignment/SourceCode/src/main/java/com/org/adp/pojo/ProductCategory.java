package com.org.adp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRODUCT_CATEGORY", uniqueConstraints = {@UniqueConstraint(columnNames = "CATEGORY_ID")})
public class ProductCategory {
	@Id
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private int categoryId;

	@Column(name = "CATEGORY_NAME", unique = false, nullable = false)
	private String categoryName;

	public ProductCategory(){
		
	}
	
	public ProductCategory(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public boolean equals(Object prodCategory){
		if(prodCategory == null)
			return false;
		if(prodCategory instanceof ProductCategory ){
			if( this.categoryId == (((ProductCategory) prodCategory).getCategoryId())
					&& this.categoryName.equals(((ProductCategory) prodCategory).getCategoryName()))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	public int hashCode(){
		int result = 17;
        result = 31 * result + categoryName.hashCode();
        return result;
	}
	
}
