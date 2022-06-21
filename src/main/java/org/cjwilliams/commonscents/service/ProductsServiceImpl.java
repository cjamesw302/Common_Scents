package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.model.Products;
import org.cjwilliams.commonscents.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public Products findByid(long id) {
		return productsRepository.findByid(id);
	}
}