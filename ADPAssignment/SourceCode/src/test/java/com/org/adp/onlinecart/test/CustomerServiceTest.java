package com.org.adp.onlinecart.test;

import org.junit.Test;

import com.org.adp.onlinecart.service.CustomerServiceImpl;
import com.org.adp.onlinecart.service.ICustomerService;
import com.org.adp.onlinecart.utils.ApplicationException;
import com.org.adp.pojo.Customer;

import static org.junit.Assert.*;
public class CustomerServiceTest {
	
	@Test
	public void testForAdd() throws ApplicationException {
		ICustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(1, "Navneet");
        Customer cust = customerService.searchCustomerById(1);
        assertNotNull(cust);
        cust = customerService.searchCustomerById(99);
        assertNull(cust);
	}
	
	@Test(expected= ApplicationException.class)
	public void testForAddException() throws ApplicationException {
		ICustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(44, "Navneet");
        customerService.addCustomer(44, "Navneet");
	}
	
	@Test
	public void testForDelete()  throws ApplicationException {
		ICustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(88, "Navneet");
        Customer cust = customerService.searchCustomerById(88);
        assertNotNull(cust);
        customerService.deleteCustomer(88);
        cust = customerService.searchCustomerById(88);
        assertNull(cust);
	}
	
	@Test(expected= ApplicationException.class)
	public void testForDeleteException() throws ApplicationException {
		ICustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(99, "Navneet");
        Customer cust = customerService.searchCustomerById(99);
        assertNotNull(cust);
        customerService.deleteCustomer(99);
        customerService.deleteCustomer(99);
	}
	@Test
	public void tetsForUpdate() throws ApplicationException {
		ICustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(33, "Navneet");	
        Customer cust = customerService.searchCustomerById(33);
        assertNotNull(cust);
        String updatedName = "NavneetUpdated";
        cust.setCustName(updatedName);
        customerService.updateCustomer(33,cust);
        cust = customerService.searchCustomerById(33);
        assertNotNull(cust);
        assertEquals(cust.getCustName(),updatedName);
	}
	@Test(expected= ApplicationException.class)
	public void tetsForUpdateException() throws ApplicationException {
		ICustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(55, "Navneet");	
        Customer cust = customerService.searchCustomerById(55);
        customerService.updateCustomer(10000,cust);
	}
}
