package com.org.adp.onlinecart.dao;

import java.util.List;

import org.hibernate.Session;

import com.org.adp.onlinecart.utils.HibernateUtil;
import com.org.adp.pojo.Customer;

public class CustomerDao {
	public void addCustomer(Customer cust){
		if(cust != null){
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(cust);
	        session.getTransaction().commit();
	        session.close();
		}
	}
	public void deleteCustomer(int custId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer cust = session.get(Customer.class, custId);
        session.delete(cust);
        session.getTransaction().commit();
        session.close();
	}
	public List<Customer> getAllCustomers(){
	
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Customer> custList = session.createQuery("FROM Customer").list();
        session.close();
        return custList;
	}
	public Customer searchCustomer(int custId){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer cust = session.get(Customer.class, custId);
        session.close();
        return cust;
	}
	public void updateCustomer(int custId, Customer custToUpdate){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer custFromDb = session.get(Customer.class, custId);
        custFromDb.setCustName(custToUpdate.getCustName());
        session.update(custFromDb);
        session.getTransaction().commit();
        session.close();
	}
}
