package com.org.adp.onlinecart.service;

import java.util.List;

import com.org.adp.pojo.OrderItem;
import com.org.adp.pojo.Product;
import com.org.adp.pojo.SalesOrder;

public interface ISalesOrderService {
	void addProductToCart(SalesOrder so, Product product);
	void removeProductFromCart(SalesOrder so, Product product);
	void updateQuantity(SalesOrder so, Product product, int quantity);
	List<OrderItem> getAllOrderItems(SalesOrder so);
	void computeTotals(SalesOrder so);
	void checkOut(SalesOrder so);
}
