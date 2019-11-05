package com.org.adp.onlinecart.dao;

import java.util.List;

import org.hibernate.Session;

import com.org.adp.onlinecart.utils.HibernateUtil;
import com.org.adp.pojo.Customer;
import com.org.adp.pojo.ProductCategory;

public class ProductCategoryDao {
	
	public void addProductCategory(ProductCategory category){
		if(category != null){
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(category);
	        session.getTransaction().commit();
	        session.close();
		}
	}
	public void deleteProductCategory(int cateogryId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ProductCategory category = session.get(ProductCategory.class, cateogryId);
        session.delete(category);
        session.getTransaction().commit();
        session.close();
	}
	public void updateProductCategory(int cateogryId, ProductCategory productCategoryToUpdate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ProductCategory categoryFromDB = session.get(ProductCategory.class, cateogryId);
        categoryFromDB.setCategoryName(productCategoryToUpdate.getCategoryName());
        session.update(categoryFromDB);
        session.getTransaction().commit();
        session.close();
	}
	public ProductCategory searchProductCategoryById(int cateogryId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ProductCategory category = session.get(ProductCategory.class, cateogryId);
        session.close();
        return category;
	}
	public List<ProductCategory> getAllProductCategories() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<ProductCategory> productCateogryList = session.createQuery("FROM ProductCategory").list();
        session.close();
        return productCateogryList;
	}
}
