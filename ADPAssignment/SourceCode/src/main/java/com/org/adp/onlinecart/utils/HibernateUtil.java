package com.org.adp.onlinecart.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.org.adp.pojo.Customer;
import com.org.adp.pojo.OrderItem;
import com.org.adp.pojo.Product;
import com.org.adp.pojo.ProductCategory;
import com.org.adp.pojo.SalesOrder;

public class HibernateUtil
{
   private static SessionFactory sessionFactory = buildSessionFactory();

   private static SessionFactory buildSessionFactory()
   {
      try
      {
         if (sessionFactory == null)
         {
            Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(ProductCategory.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(SalesOrder.class);
            configuration.addAnnotatedClass(OrderItem.class);
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

         }
         return sessionFactory;
      } catch (Throwable ex)
      {
         System.err.println("Initial SessionFactory creation failed." + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }

   public static SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }

   public static void shutdown()
   {
      getSessionFactory().close();
   }
}