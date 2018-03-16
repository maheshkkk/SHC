package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomer();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theid);

}
