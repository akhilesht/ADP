package com.org.adp.onlinecart.service;

import java.util.List;

import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.pojo.Customer;

public interface ICustomerService {
	
	void addCustomer(int custId, String custName) throws ApplicationException;
	void deleteCustomer(int custId) throws ApplicationException;
	void updateCustomer(int custId,  Customer customer) throws ApplicationException;
	Customer searchCustomerById(int custId);
	List<Customer> getAllCustomers(); 
}
