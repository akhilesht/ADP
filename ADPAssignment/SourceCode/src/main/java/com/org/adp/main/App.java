package com.org.adp.main;

import java.util.List;

import com.org.adp.onlinecart.service.BillingServiceImpl;
import com.org.adp.onlinecart.service.CustomerServiceImpl;
import com.org.adp.onlinecart.service.IBillingService;
import com.org.adp.onlinecart.service.ICustomerService;
import com.org.adp.onlinecart.service.IProductCategoryService;
import com.org.adp.onlinecart.service.IProductService;
import com.org.adp.onlinecart.service.ISalesOrderService;
import com.org.adp.onlinecart.service.ProductCategoryServiceImpl;
import com.org.adp.onlinecart.service.ProductServiceImpl;
import com.org.adp.onlinecart.service.SalesOrderServiceImpl;
import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.pojo.Customer;
import com.org.adp.pojo.Product;
import com.org.adp.pojo.ProductCategory;
import com.org.adp.pojo.SalesOrder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    { 
    	try{
    		sampleRun();
    	}
    	catch(ApplicationException ex){
    		System.out.println("ApplicationException occured " + ex.getMessage());
    	}
    }
    
    private static void sampleRun() throws ApplicationException {
    	System.out.println("\n\n Running with sample inputs ..... \n\n");
    	
    	System.out.println("Adding Customers..... \n");
    	
    	ICustomerService customerService = new CustomerServiceImpl();
    	customerService.addCustomer(101, "Anand");
    	customerService.addCustomer(102, "Dilip");
    	customerService.addCustomer(103, "Durga");
    	customerService.addCustomer(104, "Vaibhav");
    	customerService.addCustomer(105, "Maya");
    	System.out.println("Added 5 Customers..... \n");
    	
    	System.out.println("Adding Product Categories... \n");
        IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
        productCategoryService.addProductCategory(1, "A");
        productCategoryService.addProductCategory(2, "B");
        productCategoryService.addProductCategory(3, "C");
        
        System.out.println("Added 3 Product Categories... \n");
        
        System.out.println("Adding products... \n");
        IProductService productService = new ProductServiceImpl();
		ProductCategory category = productCategoryService.searchProductCategoryById(1);
		
		Product product1 = new Product(1, "India Gate Basmati Rice (5 kg pack) ", category, 1000.00);
		productService.addProduct(product1);
		
		Product product2 = new Product(2, "Aashirvad aata (10 kg pack) ", category, 400.00);
		productService.addProduct(product2);
		
		Product product3 = new Product(3, "Tata toor Dal (5 kg pack)", category, 700.00);
		productService.addProduct(product3);
        
		category = productCategoryService.searchProductCategoryById(2);
		Product product4 = new Product(4, "Raymond Shirt ", category, 950.00);
		productService.addProduct(product4);
        
		Product product5 = new Product(5, "Raymond Pant ", category, 850.00);
		productService.addProduct(product5);
		
		Product product6 = new Product(6, "Wrangler Jeans ", category, 1200.00);
		productService.addProduct(product6);
		
		category = productCategoryService.searchProductCategoryById(3);
		Product product7 = new Product(7, "Harry Potter Complete Series ", category, 2500.00);
		productService.addProduct(product7);
		
		Product product8 = new Product(8, "The Lord of the rings ", category, 695.00);
		productService.addProduct(product8);
		
		System.out.println("Added 8 products... \n");
		
		System.out.println("Creating Sales Order... \n");
		
		ISalesOrderService salesOrderService = new SalesOrderServiceImpl();
		Customer cust = customerService.searchCustomerById(101);
		SalesOrder so = new SalesOrder(cust);
		
		System.out.println("Adding Products to Sales Order/Cart... \n");
		salesOrderService.addProductToCart(so, product1);
		salesOrderService.addProductToCart(so, product2);
		salesOrderService.addProductToCart(so, product3);
		salesOrderService.addProductToCart(so, product4);
		salesOrderService.addProductToCart(so, product7);
		
		System.out.println("Updating quantities... \n");
		salesOrderService.updateQuantity(so, product1, 2);
		salesOrderService.updateQuantity(so, product2, 4);
		salesOrderService.updateQuantity(so, product3, 3);
		salesOrderService.updateQuantity(so, product4, 6);
		salesOrderService.updateQuantity(so, product7, 2);

		System.out.println("Computing total... \n");
		salesOrderService.checkOut(so);

        
        System.out.println("Generating Bill... \n");
        IBillingService billingService = new BillingServiceImpl();
        billingService.generateBill(so);
		
    }
}
