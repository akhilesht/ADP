package com.org.adp.onlinecart.service;

import java.util.List;

import com.org.adp.onlinecart.dao.ProductCategoryDao;
import com.org.adp.onlinecart.dao.ProductDao;
import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.onlinecart.utils.ErrorCodes;
import com.org.adp.pojo.Product;

public class ProductServiceImpl implements IProductService {

	public void addProduct(Product product)throws ApplicationException {
		Product productFromDB  = searchProductById(product.getProductId());
		
		if(productFromDB!=null && (product.getProductId()==productFromDB.getProductId()
				|| product.getProductName().equals(productFromDB.getProductName())) ){
			throw new ApplicationException(ErrorCodes.PRODUCT_ALREADY_EXISTS.toString());
		}
		
		ProductDao productDao = new ProductDao();
		productDao.addProduct(product);
	}

	public void deleteProduct(int productId) throws ApplicationException {
		if(searchProductById(productId)==null){
			throw new ApplicationException(ErrorCodes.PRODUCT_DOESNOT_EXISTS.toString());
		}
		ProductDao productDao = new ProductDao();
		productDao.deleteProduct(productId);
	}

	public void updateProduct(int productId, Product productToUpdate)throws ApplicationException {
		if(searchProductById(productId)==null){
			throw new ApplicationException(ErrorCodes.PRODUCT_DOESNOT_EXISTS.toString());
		}
		ProductDao productDao = new ProductDao();
		productDao.updateProduct(productId, productToUpdate);
	}

	public Product searchProductById(int productId) {
		ProductDao productDao = new ProductDao();
		return productDao.searchProductById(productId); 
	}

	public List<Product> getAllProducts() {
		ProductDao productDao = new ProductDao();
		return productDao.getAllProducts(); 
	}
}
