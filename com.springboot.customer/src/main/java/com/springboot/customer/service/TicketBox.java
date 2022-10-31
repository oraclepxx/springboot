package com.springboot.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class TicketBox {

	@Autowired
	private DiscoveryClient discoveryClient;

	public String getService() {
		List<ServiceInstance> list = discoveryClient.getInstances("STORES");
		if (list != null && list.size() > 0) {
			return list.get(0).getUri().toString();
		}
		return null;
	}

}
