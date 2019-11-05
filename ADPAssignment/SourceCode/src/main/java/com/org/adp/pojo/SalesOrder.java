package com.org.adp.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SALESORDER", uniqueConstraints = {@UniqueConstraint(columnNames = "SALESORDER_ID")})
public class SalesOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SALESORDER_ID", unique = true, nullable = false)
	private int salesOrderId;
	
	@OneToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	@OneToMany
	@JoinTable(name="SALESORDER_ORDERITEM",joinColumns=@JoinColumn(name="SALESORDER_ID"),
		inverseJoinColumns=@JoinColumn(name="ORDER_ITEM_ID"))
	private List<OrderItem> orderItemList;
	
	@Column(name = "TOTAL_AMOUNT_WITHOUT_TAX", unique = true, nullable = false)
	private double totalAmountWithoutTax;
	
	@Column(name = "TOTAL_TAX", unique = true, nullable = false)
	private double totalTax;
	
	@Column(name = "TOTAL_AMOUNT_WITH_TAX", unique = true, nullable = false)
	private double totalAmountWithTax;

	public SalesOrder() {
		super();
	}
	
	public SalesOrder(Customer customer) {
		super();
		this.customer = customer;
	}
	
	public int getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public double getTotalAmountWithoutTax() {
		return totalAmountWithoutTax;
	}

	public void setTotalAmountWithoutTax(double totalAmountWithoutTax) {
		this.totalAmountWithoutTax = totalAmountWithoutTax;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalAmountWithTax() {
		return totalAmountWithTax;
	}

	public void setTotalAmountWithTax(double totalAmountWithTax) {
		this.totalAmountWithTax = totalAmountWithTax;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
