package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Customer;
import com.shopping.service.CustomerDaoService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDaoService custService;
	
	@RequestMapping("/customer")
	public List<Customer> getAllUstomer(){
		return custService.getCustomer();
	}
	
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer customer) {
		custService.addCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	public void updateCustomer(@RequestBody Customer customer) {
		custService.updateCustomer(customer);
	}
	

	@DeleteMapping("/deleteCustomer")
	public void removeCustomer(Customer customer) {
		custService.removeCustomer(customer);
	}
	
}
