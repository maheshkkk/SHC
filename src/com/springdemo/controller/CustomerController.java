package com.springdemo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need the inject customer sevice
@Autowired
private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model themodel) {

	// get the customer service	
		List<Customer> theCustomers =customerService.getCustomer();
		
	// add the customer add model	
		themodel.addAttribute("Customer", theCustomers);
		
		return "list-customer";
	}

		
	@GetMapping("/showFormForAdd")	
	public String showFromForAdd(Model themodel) {
		Customer thecustomer=new Customer();
		
    themodel.addAttribute("customer",thecustomer);
		 
		return "customer-from";
	}
	
	@PostMapping("/saveForm")
	public  String saveCustomer(@ModelAttribute("customer") Customer thecustomer) {
		customerService.saveCustomer(thecustomer);
		return "redirect:/customer/list";	
	 }
	@GetMapping("/showFromForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model themodel ) {
		// get customer form database
		Customer thecustomer=customerService.getCustomer(theId);
		//set the model  atrrtibute to pre the form
		themodel.addAttribute("customer",thecustomer );
		
		//send the from
		
		return "customer-from";	
		}
	@GetMapping("/DeleteFrom")
	public String deletecustomer(@RequestParam("customerId") int theid) {
		customerService.deleteCustomer(theid);
		return "redirect:/customer/list";	
	}
	
			

}
