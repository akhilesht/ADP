package com.org.adp.onlinecart.dao;

import java.util.List;

import org.hibernate.Session;

import com.org.adp.onlinecart.utils.HibernateUtil;
import com.org.adp.pojo.Customer;
import com.org.adp.pojo.Product;

public class ProductDao {
	public void addProduct(Product product){
		if(product != null){
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(product);
	        session.getTransaction().commit();
	        session.close();
		}
	}
	public void deleteProduct(int productId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, productId);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
	}
	public void updateProduct(int productId, Product productToUpdate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product productFromDB = session.get(Product.class, productId);
        productFromDB.setProductName(productToUpdate.getProductName());
        productFromDB.setRate(productToUpdate.getRate());
        productFromDB.setCategory(productToUpdate.getCategory());
        session.update(productFromDB);
        session.getTransaction().commit();
        session.close();
	}
	public List<Product> getAllProducts() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Product> productList = session.createQuery("FROM Product").list();
        session.close();
        return productList;
	}
	public Product searchProductById(int productId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, productId);
        session.close();
        return product;
	}
}
