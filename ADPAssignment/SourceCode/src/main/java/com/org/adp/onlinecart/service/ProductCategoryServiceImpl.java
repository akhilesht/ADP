package com.org.adp.onlinecart.service;

import java.util.List;
import com.org.adp.onlinecart.dao.ProductCategoryDao;
import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.onlinecart.utils.ErrorCodes;
import com.org.adp.pojo.ProductCategory;

public class ProductCategoryServiceImpl implements IProductCategoryService {

	public void addProductCategory(int cateogryId, String categoryName) throws ApplicationException{
		if(searchProductCategoryById(cateogryId)!=null){
			throw new ApplicationException(ErrorCodes.PRODUCT_CATEGORY_ALREADY_EXISTS.toString());
		}
		ProductCategory productCategory = new ProductCategory(cateogryId, categoryName);
		ProductCategoryDao productCategoryDao = new ProductCategoryDao();
		productCategoryDao.addProductCategory(productCategory);
	}

	public void deleteProductCategory(int cateogryId) throws ApplicationException{
		if(searchProductCategoryById(cateogryId)==null){
			throw new ApplicationException(ErrorCodes.PRODUCT_CATEGORY_DOESNOT_EXISTS.toString());
		}
		ProductCategoryDao productCategoryDao = new ProductCategoryDao();
		productCategoryDao.deleteProductCategory(cateogryId);
		
	}

	public void updateProductCategory(int cateogryId, ProductCategory productCategory) throws ApplicationException {
		if(searchProductCategoryById(cateogryId)==null){
			throw new ApplicationException(ErrorCodes.PRODUCT_CATEGORY_DOESNOT_EXISTS.toString());
		}
		ProductCategoryDao productCategoryDao = new ProductCategoryDao();
		productCategoryDao.updateProductCategory(cateogryId, productCategory);
	}

	public ProductCategory searchProductCategoryById(int cateogryId) {
		ProductCategoryDao productCategoryDao = new ProductCategoryDao();
		return productCategoryDao.searchProductCategoryById(cateogryId); 
	}

	public List<ProductCategory> getAllProductCategories() {
		ProductCategoryDao productCategoryDao = new ProductCategoryDao();
		return productCategoryDao.getAllProductCategories(); 
	}

}
