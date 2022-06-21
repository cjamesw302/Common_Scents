package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.model.Products;

//Interface for products service

public interface ProductsService {
	Products findByid(long id);
}