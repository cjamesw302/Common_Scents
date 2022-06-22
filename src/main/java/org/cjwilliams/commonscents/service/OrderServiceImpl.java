package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

//Implementation of order service

@Service
@Lazy
public class OrderServiceImpl implements OrderService {
	@Autowired
    private OrderRepository orderRepository;
	
	//Saves gets and sets current order details to database
	
	@Override
	public Orders save(Orders registration) {
		Orders order = new Orders();
		order.setAddress(registration.getAddress());
		order.setCity(registration.getCity());
		order.setState(registration.getState());
		order.setZip(registration.getZip());
		order.setOrderDate(registration.getOrderDate());
		return orderRepository.save(registration);
	}
}