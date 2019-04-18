package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.entity.Customer;

public interface CustomerDAO {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);

	List<Customer> searchCustomer(String searchValue);

}
