package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.model.Orders;

//Interface for order service

public interface OrderService{
	//Gets and sets current order details to database
	Orders save(Orders order);
}