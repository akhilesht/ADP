package com.org.adp.onlinecart.service;

import java.util.List;

import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.pojo.ProductCategory;

public interface IProductCategoryService {
	void addProductCategory(int categoryId, String categoryName)throws ApplicationException;
	void deleteProductCategory(int categoryId)throws ApplicationException;
	void updateProductCategory(int categoryId,  ProductCategory productCategory)throws ApplicationException;
	ProductCategory searchProductCategoryById(int categoryId);
	List<ProductCategory> getAllProductCategories(); 
}
