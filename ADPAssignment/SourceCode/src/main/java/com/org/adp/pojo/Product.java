package com.org.adp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRODUCT", uniqueConstraints = {@UniqueConstraint(columnNames = "PRODUCT_ID")})
public class Product {
	
	@Id
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	private int productId;
	
	@Column(name = "PRODUCT_NAME", unique = true, nullable = false)
	private String productName;
	
	@OneToOne
	@JoinColumn(name="CATEGORY_ID")
	ProductCategory category;
	
	@Column(name = "RATE", unique = false, nullable = false)
	double rate;
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Product(){
		
	}

	public Product(int productId, String productName, ProductCategory category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
	}

	
	public Product(int productId, String productName, ProductCategory category, double rate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.rate = rate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	public boolean equals(Object product) {
		if(product == null)
			return false;
		if(product instanceof Product ){
			if(this.productId == (((Product) product).getProductId())
				&& this.productName.equals(((Product) product).getProductName())
				&& this.category.equals(((Product) product).getCategory()))
				return true;
			else
				return false;
		}
		return false;
	}

	public int hashCode(){
		int result = 17;
        result = 31 * result + productName.hashCode();
        result = 31 * result + category.hashCode();
        return result;
	}
	

}
