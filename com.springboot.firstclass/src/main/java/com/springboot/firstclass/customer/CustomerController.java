package com.springboot.firstclass.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping()
	public List<Customer> addCustomer(@RequestBody Customer customer) throws Exception {
		customerService.createCustomer(customer.getName());
		return customerService.listCustomer();
	}

	@GetMapping()
	public List<Customer> listCustomers() {
		return customerService.listCustomer();
	}
	
	@DeleteMapping("{id}")
	public List<Customer> remvoeCustomer(@PathVariable int id) throws Exception {
		customerService.deleteCustomer(id);
		return customerService.listCustomer();
	}
	
	@PutMapping()
	public List<Customer> updateCustomer(@RequestBody Customer customer) throws Exception {
		customerService.updateCustomer(customer);
		return customerService.listCustomer();
	}
}
