package com.org.adp.onlinecart.test;

import org.junit.Test;

import com.org.adp.onlinecart.service.BillingServiceImpl;
import com.org.adp.onlinecart.service.IProductCategoryService;
import com.org.adp.onlinecart.service.IProductService;
import com.org.adp.onlinecart.service.ISalesOrderService;
import com.org.adp.onlinecart.service.ProductCategoryServiceImpl;
import com.org.adp.onlinecart.service.ProductServiceImpl;
import com.org.adp.onlinecart.service.SalesOrderServiceImpl;
import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.pojo.OrderItem;
import com.org.adp.pojo.Product;
import com.org.adp.pojo.ProductCategory;
import com.org.adp.pojo.SalesOrder;
import static org.junit.Assert.*;

import java.util.List;

public class SalesOrderServiceTest {
	@Test
	public void test() throws ApplicationException{
		IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		
		IProductService productService = new ProductServiceImpl();
		ProductCategory categoryA = productCategoryService.searchProductCategoryById(1);
		if(categoryA==null){
			productCategoryService.addProductCategory(1, "A");
			categoryA = productCategoryService.searchProductCategoryById(1);
		}
		
		ProductCategory categoryB = productCategoryService.searchProductCategoryById(2);
		if(categoryB==null){
			productCategoryService.addProductCategory(2, "B");
			categoryB = productCategoryService.searchProductCategoryById(2);
		}
		
		ProductCategory categoryC = productCategoryService.searchProductCategoryById(3);
		if(categoryC==null){
			productCategoryService.addProductCategory(3, "C");
			categoryC = productCategoryService.searchProductCategoryById(3);
		}
		
		assertNotNull(categoryA);
		assertNotNull(categoryB);
		assertNotNull(categoryC);
		
		
		Product product1 = new Product(5555, "Product 5555 ", categoryA, 1000.00);
		Product product2 = new Product(6666, "Product 6666 ", categoryB, 800.00);
		Product product3 = new Product(7777, "Product 7777 ", categoryC, 900.00);
		productService.addProduct(product1);
		productService.addProduct(product2);
		productService.addProduct(product3);
		
		ISalesOrderService salesOrderService  = new SalesOrderServiceImpl();
		SalesOrder so = new SalesOrder();
		salesOrderService.addProductToCart(so, product1);
		salesOrderService.addProductToCart(so, product2);
		salesOrderService.addProductToCart(so, product3);		
		
		salesOrderService.updateQuantity(so, product1, 3);
		salesOrderService.updateQuantity(so, product2, 2);
		
		List<OrderItem> orderItemList = salesOrderService.getAllOrderItems(so);
		assertEquals(orderItemList.size(),3);
		salesOrderService.computeTotals(so);
				
		double totalAmtWithoutTax  = so.getTotalAmountWithoutTax();
		double totalTax  = so.getTotalTax();
		double totalAmtWithTax = so.getTotalAmountWithTax();
		
		
		assertEquals(totalAmtWithoutTax, 5500.00,0.00);
		assertEquals(totalTax, 620,0.00);
		assertEquals(totalAmtWithTax, 6120,0.00);
	}

}
