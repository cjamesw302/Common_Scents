package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

//Implementation of order service that sets corresponding model attributes and saves them to the database

@Service
@Lazy
public class OrderServiceImpl implements OrderService {
	@Autowired
    private OrderRepository orderRepository;
	
	@Override
	public Orders save(Orders registration) {
		Orders order = new Orders();
		order.setOrderDate(registration.getOrderDate());
		return orderRepository.save(registration);
	}
}