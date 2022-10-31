package com.springboot.firstclass.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private Order order;

	@RequestMapping("/orders")
	public String listOrders() {
		
		return "listOrders";
	}
	
	@RequestMapping("/order")
	public Order getOrder() {
		return this.order;
	}
	
}
