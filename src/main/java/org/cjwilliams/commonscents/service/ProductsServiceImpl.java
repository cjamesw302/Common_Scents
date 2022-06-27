package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.exception.CSException;
import org.cjwilliams.commonscents.model.Products;
import org.cjwilliams.commonscents.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

//Implementation of products service

@Service
@Lazy
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsRepository productsRepository;

	//Returns product by corresponding id
	
	@Override
	public Products findByid(@RequestParam Long id) throws CSException{
		if(id == null) {
			throw new CSException("id does not exist");
		}
		return productsRepository.findByid(id);
	}
}