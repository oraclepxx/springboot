package com.springboot.firstclass.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private Order order;

	public Order getOrder() {
		return this.order;
	}

}
