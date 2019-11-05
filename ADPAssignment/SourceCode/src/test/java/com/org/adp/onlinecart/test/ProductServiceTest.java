package com.org.adp.onlinecart.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.org.adp.onlinecart.service.CustomerServiceImpl;
import com.org.adp.onlinecart.service.ICustomerService;
import com.org.adp.onlinecart.service.IProductCategoryService;
import com.org.adp.onlinecart.service.IProductService;
import com.org.adp.onlinecart.service.ProductCategoryServiceImpl;
import com.org.adp.onlinecart.service.ProductServiceImpl;
import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.pojo.Customer;
import com.org.adp.pojo.Product;
import com.org.adp.pojo.ProductCategory;

public class ProductServiceTest {
	
	@Test
	public void testForAdd() throws ApplicationException {
		IProductService productService = new ProductServiceImpl();
	    IProductCategoryService productCateogryService = new ProductCategoryServiceImpl();
	    productCateogryService.addProductCategory(5555, "Category 5555");
		ProductCategory category = productCateogryService.searchProductCategoryById(5555);
		Product product = new Product(2001, "Test Product ", category, 1000.00);
		productService.addProduct(product);
		product = productService.searchProductById(2001);
        assertNotNull(product);
        product = productService.searchProductById(9999);
        assertNull(product);
	}
	
	@Test(expected = ApplicationException.class)
	public void testForAddException() throws ApplicationException {
		IProductService productService = new ProductServiceImpl();
	    IProductCategoryService productCateogryService = new ProductCategoryServiceImpl();
	    productCateogryService.addProductCategory(6666, "Category 6666");
		ProductCategory category = productCateogryService.searchProductCategoryById(6666);
		Product product = new Product(3001, "Test Product 123", category, 1000.00);
		productService.addProduct(product);
		productService.addProduct(product);
	}
	
	@Test
	public void testForDelete() throws ApplicationException {
		IProductService productService = new ProductServiceImpl();
	    IProductCategoryService productCateogryService = new ProductCategoryServiceImpl();
	    productCateogryService.addProductCategory(7777, "Category 7777");
		ProductCategory category = productCateogryService.searchProductCategoryById(7777);
		Product product = new Product(4001, "Test Product 2 ", category, 1000.00);
		productService.addProduct(product);
		product = productService.searchProductById(4001);
        assertNotNull(product);
        productService.deleteProduct(4001);
        product = productService.searchProductById(4001);
        assertNull(product);
	}
	
	@Test(expected = ApplicationException.class)
	public void testForDeleteException() throws ApplicationException {
		IProductService productService = new ProductServiceImpl();
	    IProductCategoryService productCateogryService = new ProductCategoryServiceImpl();
	    productCateogryService.addProductCategory(8888, "Category 8888");
		ProductCategory category = productCateogryService.searchProductCategoryById(8888);
		Product product = new Product(5001, "Test Product 5001 ", category, 1000.00);
		productService.addProduct(product);
		product = productService.searchProductById(5001);
        assertNotNull(product);
        productService.deleteProduct(5001);
        productService.deleteProduct(5001);
	}
	
	@Test
	public void tetsForUpdate() throws ApplicationException{
		IProductService productService = new ProductServiceImpl();
	    IProductCategoryService productCateogryService = new ProductCategoryServiceImpl();
	    productCateogryService.addProductCategory(9999, "Category 9999");
		ProductCategory category = productCateogryService.searchProductCategoryById(9999);
		Product product = new Product(6001, "Test Product 6001 ", category, 1000.00);
		productService.addProduct(product);
		product = productService.searchProductById(6001);
        assertNotNull(product);
        
        String updatedName = "new name";
        ProductCategory updatedCategory = productCateogryService.searchProductCategoryById(8888);
        product.setCategory(updatedCategory);
        product.setRate(2000.00);
        product.setProductName(updatedName);

        productService.updateProduct(product.getProductId(), product);
        product = productService.searchProductById(6001);
        assertNotNull(product);
        assertEquals(product.getCategory(),updatedCategory);
        assertEquals(product.getRate(),2000.00,0.0);
        assertEquals(product.getProductName(),updatedName);
        
	}
	
	@Test(expected = ApplicationException.class)
	public void tetsForUpdateException() throws ApplicationException{
		IProductService productService = new ProductServiceImpl();
	    IProductCategoryService productCateogryService = new ProductCategoryServiceImpl();
	    productCateogryService.addProductCategory(1111, "Category 1111");
		ProductCategory category = productCateogryService.searchProductCategoryById(1111);
		Product product = new Product(7001, "Test Product 7001 ", category, 1000.00);
		productService.addProduct(product);
		product = productService.searchProductById(7001);
        assertNotNull(product);
        
        String updatedName = "new name";
        ProductCategory updatedCategory = productCateogryService.searchProductCategoryById(8888);
        product.setCategory(updatedCategory);
        product.setRate(2000.00);
        product.setProductName(updatedName);

        productService.updateProduct(9999, product);
  	}
}
