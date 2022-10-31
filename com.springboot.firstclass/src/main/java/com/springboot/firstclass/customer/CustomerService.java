package com.springboot.firstclass.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private List<Customer> customers = new ArrayList<Customer>();
	private Map<Integer, Boolean> idMap = new HashMap<Integer, Boolean>();
	
	private static int tempId = 10000;

	public void createCustomer(String name) throws Exception {
		if (!checkExistingCustomer(name)) {
			int id = getCustomerId();
			Customer c = new Customer(name);
			c.setId(id);
			this.customers.add(c);
			return;
		} 
		throw new Exception("Customer is existing");
	}

	public List<Customer> listCustomer() {
		return this.customers;
	}
	
	public void deleteCustomer(int id) throws Exception {
		if (idMap.get(id) == null) {
			throw new Exception("Customer id not found");
		}
		idMap.remove(id);
		List<Customer> tList = new ArrayList<Customer>();
		for (Customer c: this.customers) {
			if (c.getId() != id) {
				tList.add(c);
			}
		}
		this.customers = tList;
	}
	
	public void updateCustomer(Customer customer) throws Exception {
		if (idMap.get(customer.getId()) == null) {
			throw new Exception("Customer id not found");
		}
		if (checkExistingCustomer(customer.getName())) {
			throw new Exception("Customer is existing");
		}
		for (Customer c: this.customers) {
			if (c.getId() == customer.getId()) {
				c.setName(customer.getName());
				return;
			}
		}
		
	}

	private boolean checkExistingCustomer(String name) {
		for (Customer c : this.customers) {
			if (name.equals(c.getName())) {
				return true;
			}
		}
		return false;
	}

	private int getCustomerId() {
		if (idMap.get(tempId) != null) {
			tempId++;
		} 
		idMap.put(tempId, true);
		return tempId;
	}

}
