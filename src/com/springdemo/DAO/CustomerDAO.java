package com.springdemo.DAO;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerDAO {
	public List <Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);



	public Customer getCustomer(int theId);



	public void deleteCustomer(int theid);

	





}
