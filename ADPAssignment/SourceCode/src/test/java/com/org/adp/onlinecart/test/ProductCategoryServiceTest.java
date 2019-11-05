package com.org.adp.onlinecart.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.org.adp.onlinecart.service.IProductCategoryService;
import com.org.adp.onlinecart.service.ProductCategoryServiceImpl;
import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.pojo.ProductCategory;

public class ProductCategoryServiceTest {
	
	@Test
	public void testForAdd() throws ApplicationException{
		IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		productCategoryService.addProductCategory(1001, "Cateogry 1001");
		productCategoryService.addProductCategory(1002, "Cateogry 1002");
		productCategoryService.addProductCategory(1003, "Cateogry 1003");
        ProductCategory category = productCategoryService.searchProductCategoryById(1001);
        assertNotNull(category);
        category = productCategoryService.searchProductCategoryById(99);
        assertNull(category);
	}
	
	@Test(expected = ApplicationException.class)
	public void testForAddException() throws ApplicationException{
		IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		productCategoryService.addProductCategory(2001, "Cateogry 2001");
		productCategoryService.addProductCategory(2002, "Cateogry 2002");
		productCategoryService.addProductCategory(2003, "Cateogry 2003");
		productCategoryService.addProductCategory(2001, "Cateogry 2001");
		productCategoryService.addProductCategory(2002, "Cateogry 2002");
		productCategoryService.addProductCategory(2003, "Cateogry 2003");
	}
	@Test
	public void testForDelete() throws ApplicationException{
		IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		productCategoryService.addProductCategory(3001, "Cateogry 3001");
		ProductCategory category = productCategoryService.searchProductCategoryById(3001);
	    assertNotNull(category);
	    productCategoryService.deleteProductCategory(3001);
	    category = productCategoryService.searchProductCategoryById(3001);
        assertNull(category);
	}
	@Test(expected = ApplicationException.class)
	public void testForDeleteException() throws ApplicationException{
		IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		productCategoryService.addProductCategory(4001, "Cateogry 4001");
		ProductCategory category = productCategoryService.searchProductCategoryById(4001);
	    productCategoryService.deleteProductCategory(4001);
	    productCategoryService.deleteProductCategory(4001);
	}
	
	@Test
	public void tetsForUpdate() throws ApplicationException{
		IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		productCategoryService.addProductCategory(5001, "Cateogry 5001");
		ProductCategory category = productCategoryService.searchProductCategoryById(5001);
	    assertNotNull(category);
        String updatedName = "HHHH";
        category.setCategoryName(updatedName);
        productCategoryService.updateProductCategory(5001, category);
        category = productCategoryService.searchProductCategoryById(5001);
        assertNotNull(category);
        assertEquals(category.getCategoryName(),updatedName);
	} 
	
	@Test(expected = ApplicationException.class)
	public void tetsForUpdateException() throws ApplicationException{
		IProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		productCategoryService.addProductCategory(6001, "Cateogry 6001");
		ProductCategory category = productCategoryService.searchProductCategoryById(6001);
	    assertNotNull(category);
        String updatedName = "HHHH";
        category.setCategoryName(updatedName);
        productCategoryService.updateProductCategory(7001, category);
	} 
}
