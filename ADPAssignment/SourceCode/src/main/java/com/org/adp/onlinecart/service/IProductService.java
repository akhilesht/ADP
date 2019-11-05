package com.org.adp.onlinecart.service;

import java.util.List;

import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.pojo.Product;

public interface IProductService {
	void addProduct(Product product)throws ApplicationException;
	void deleteProduct(int productId)throws ApplicationException;
	void updateProduct(int productId,  Product Product)throws ApplicationException;
	Product searchProductById(int productId);
	List<Product> getAllProducts();
	 
}
