package com.org.adp.onlinecart.service;

import java.util.List;

import com.org.adp.onlinecart.dao.CustomerDao;
import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.onlinecart.utils.ErrorCodes;
import com.org.adp.pojo.Customer;

public class CustomerServiceImpl implements ICustomerService {

	public void addCustomer(int custId, String custName) throws ApplicationException {
		if(searchCustomerById(custId)!=null){
			throw new ApplicationException(ErrorCodes.CUSTOMER_ALREADY_EXISTS.toString());
		}
		Customer cust = new Customer(custId, custName);
		CustomerDao custDao = new CustomerDao();
		custDao.addCustomer(cust);
	}

	public void deleteCustomer(int custId)  throws ApplicationException {
		if(searchCustomerById(custId)==null){
			throw new ApplicationException(ErrorCodes.CUSTOMER_DOESNOT_EXISTS.toString());
		}
		CustomerDao custDao = new CustomerDao();
		custDao.deleteCustomer(custId);
	}

	public void updateCustomer(int custId, Customer customer) throws ApplicationException  {
		if(searchCustomerById(custId)==null){
			throw new ApplicationException(ErrorCodes.CUSTOMER_DOESNOT_EXISTS.toString());
		}
		CustomerDao custDao = new CustomerDao();
		custDao.updateCustomer(custId, customer);
	}

	public Customer searchCustomerById(int custId) {
		CustomerDao custDao = new CustomerDao();
		return custDao.searchCustomer(custId); 
	}
	public List<Customer> getAllCustomers(){
		CustomerDao custDao = new CustomerDao();
		return custDao.getAllCustomers(); 
	}
}
