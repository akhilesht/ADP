package com.org.adp.onlinecart.service;

import java.util.ArrayList;
import java.util.List;

import com.org.adp.onlinecart.dao.SalesOrderDao;
import com.org.adp.pojo.OrderItem;
import com.org.adp.pojo.Product;
import com.org.adp.pojo.ProductCategory;
import com.org.adp.pojo.SalesOrder;

public class SalesOrderServiceImpl implements ISalesOrderService{

	public void addProductToCart(SalesOrder so, Product product) {
		List<OrderItem> orderItemList = so.getOrderItemList();
		
		if(orderItemList==null){
			orderItemList = new ArrayList<OrderItem>();
			so.setOrderItemList(orderItemList);
		}
		
		if(!isProductAlreadyAdded(orderItemList, product)) {
			OrderItem orderItem = new OrderItem(product);
			so.getOrderItemList().add(orderItem);
		}
	}
	
	private boolean isProductAlreadyAdded(List<OrderItem> orderItemList, Product product){
		for(OrderItem oi : orderItemList){
			if(oi.getProduct().equals(product)){
				oi.setQuantity(oi.getQuantity()+1);
				return true;
			}
		}
		return false;
	}

	public void removeProductFromCart(SalesOrder so, Product productToDelete) {
		List<OrderItem> orderItemList = so.getOrderItemList();
		if(orderItemList!=null && !orderItemList.isEmpty()){
			for(OrderItem oi : orderItemList){
				if(oi.getProduct().equals(productToDelete)){
					orderItemList.remove(oi);
					return;
				}
			}
		}
	}

	public void updateQuantity(SalesOrder so, Product productToUpdate, int newQuantity) {
		List<OrderItem> orderItemList = so.getOrderItemList();
		if(orderItemList!=null && !orderItemList.isEmpty()){
			for(OrderItem oi : orderItemList){
				if(oi.getProduct().equals(productToUpdate)){
					oi.setQuantity(newQuantity);
					return;
				}
			}
		}
	}

	public List<OrderItem> getAllOrderItems(SalesOrder so) {
		return so.getOrderItemList();
	}

	public void computeTotals(SalesOrder so) {
		
		IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		
		ProductCategory categoryA = productCategoryService.searchProductCategoryById(1);
		ProductCategory categoryB = productCategoryService.searchProductCategoryById(2);
		ProductCategory categoryC = productCategoryService.searchProductCategoryById(3);
		
		List<OrderItem> orderItemList = so.getOrderItemList();
		
		if(orderItemList!=null && !orderItemList.isEmpty()){
			for(OrderItem oi : orderItemList){
				oi.setTotalPriceWithoutTax(oi.getProduct().getRate()*oi.getQuantity());
				if(categoryA !=null && oi.getProduct().getCategory().equals(categoryA)){
					double totalPriceWithoutTax = oi.getProduct().getRate()*oi.getQuantity();
					double totalTax = oi.getProduct().getRate()*oi.getQuantity()*10/100;
					double totalPriceWithTax = totalPriceWithoutTax + totalTax;
					oi.setTax(totalTax);
					oi.setTotalPriceWithoutTax(totalPriceWithoutTax);
					oi.setTotalPriceWithTax(totalPriceWithTax);
				}
				if(categoryB !=null && oi.getProduct().getCategory().equals(categoryB)){
					double totalPriceWithoutTax = oi.getProduct().getRate()*oi.getQuantity();
					double totalTax = oi.getProduct().getRate()*oi.getQuantity()*20/100;
					double totalPriceWithTax = totalPriceWithoutTax + totalTax;
					oi.setTax(totalTax);
					oi.setTotalPriceWithoutTax(totalPriceWithoutTax);
					oi.setTotalPriceWithTax(totalPriceWithTax);
				}
				if(categoryC !=null && oi.getProduct().getCategory().equals(categoryC)){
					double totalPriceWithoutTax = oi.getProduct().getRate()*oi.getQuantity();
					double totalTax = 0;
					double totalPriceWithTax = totalPriceWithoutTax + totalTax;
					oi.setTax(totalTax);
					oi.setTotalPriceWithoutTax(totalPriceWithoutTax);
					oi.setTotalPriceWithTax(totalPriceWithTax);
				}
				double soTotalAmountWithoutTax = so.getTotalAmountWithoutTax();
				double soTotalTax = so.getTotalTax();
				so.setTotalAmountWithoutTax(soTotalAmountWithoutTax+oi.getTotalPriceWithoutTax());
				so.setTotalTax(soTotalTax+oi.getTax());
				so.setTotalAmountWithTax(so.getTotalAmountWithoutTax()+so.getTotalTax());
			}
		}
	}

	public void checkOut(SalesOrder so) {
		computeTotals(so);
		SalesOrderDao salesOrderDao = new SalesOrderDao();
		salesOrderDao.saveSalesOrder(so);	
	}
	
	
	
}