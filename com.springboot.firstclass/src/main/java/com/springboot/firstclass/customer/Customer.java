package com.springboot.firstclass.customer;

import org.springframework.stereotype.Component;

@Component
public class Customer {

	private int id;
	private String name;

	public Customer() {
	}

	public Customer(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
