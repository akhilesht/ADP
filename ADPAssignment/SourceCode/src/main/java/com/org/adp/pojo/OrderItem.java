package com.org.adp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ORDER_ITEMS", uniqueConstraints = {@UniqueConstraint(columnNames = "ORDER_ITEM_ID")})
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ITEM_ID", unique = true, nullable = false)
	private int orderItemId;
	
	@OneToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@Column(name = "QUANTITY", unique = false, nullable = false)
	private int quantity;
	
	@Column(name = "TOTAL_PRICE_WITHOUT_TAX", unique = false, nullable = false)
	private double totalPriceWithoutTax;
	
	@Column(name = "TOTAL_PRICE_WITH_TAX", unique = false, nullable = false)
	private double totalPriceWithTax;
	
	@Column(name = "TAX", unique = false, nullable = false)
	private double tax;

	
	public OrderItem(){
		
	}
	
	public OrderItem(Product product){
		super();
		this.product = product;
		this.quantity = 1;
	}

	public OrderItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPriceWithoutTax() {
		return totalPriceWithoutTax;
	}

	public void setTotalPriceWithoutTax(double totalPriceWithoutTax) {
		this.totalPriceWithoutTax = totalPriceWithoutTax;
	}

	public double getTotalPriceWithTax() {
		return totalPriceWithTax;
	}

	public void setTotalPriceWithTax(double totalPriceWithTax) {
		this.totalPriceWithTax = totalPriceWithTax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	public boolean equals(Object oi){
		if(oi == null)
			return false;
		if(oi instanceof OrderItem ){
			if(this.orderItemId == (((OrderItem) oi).getOrderItemId())
					&& this.product.equals(((OrderItem) oi).getProduct()))
				return true;
			else
				return false;
		}
		return false;
	}
	public int hashCode(){
		int result = 17;
        result = 31 * result + product.hashCode();
        return result;
	}
}
