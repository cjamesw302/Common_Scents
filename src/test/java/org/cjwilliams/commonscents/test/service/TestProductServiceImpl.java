package org.cjwilliams.commonscents.test.service;

import static org.junit.Assert.*;
import java.util.List;
import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.model.Products;
import org.cjwilliams.commonscents.repository.ProductsRepository;
import org.cjwilliams.commonscents.service.ProductsService;
import org.cjwilliams.commonscents.service.ProductsServiceImpl;
import org.junit.Test;

public class TestProductServiceImpl extends ProductsServiceImpl {
	Products product;
	List<Orders> orders;
	ProductsService productsService;
	ProductsRepository productsRepository;
	
	protected void setUp() throws Exception{
		product = new Products(1L, "Chocolate Lava Cake", "Chocolate lava cake sprinkled with powdered sugar", orders);
	}
	@Test
	public void testFindByid() {
		assertEquals(product, productsService.findByid(product.getId()));
	}
}