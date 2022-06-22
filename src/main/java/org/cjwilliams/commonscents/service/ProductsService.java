package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.model.Products;

//Interface for products service

public interface ProductsService {
	//Returns product by corresponding id
	Products findByid(Long id);
}