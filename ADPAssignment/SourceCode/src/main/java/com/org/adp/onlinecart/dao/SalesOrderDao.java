package com.org.adp.onlinecart.dao;

import java.util.List;

import org.hibernate.Session;

import com.org.adp.onlinecart.utils.HibernateUtil;
import com.org.adp.pojo.OrderItem;
import com.org.adp.pojo.SalesOrder;

public class SalesOrderDao {
	
	public void saveSalesOrder(SalesOrder so){
		if(so != null){
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(so);
	        saveOrderItems(so);
	        session.getTransaction().commit();
	        session.close();
		}
	}
	private void saveOrderItems(SalesOrder so){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<OrderItem> orderItemList = so.getOrderItemList();
        if(orderItemList!=null && !orderItemList.isEmpty()){
        	for(OrderItem oi : orderItemList){
        		session.save(oi);
        	}
        }
        session.getTransaction().commit();
        session.close();
	}
}
