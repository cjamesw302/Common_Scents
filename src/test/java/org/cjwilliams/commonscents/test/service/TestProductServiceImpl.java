package org.cjwilliams.commonscents.test.service;

import java.util.List;
import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.model.Products;
import org.cjwilliams.commonscents.repository.ProductsRepository;
import org.cjwilliams.commonscents.service.ProductsServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//Test class of ProductServiceImpl

@SpringBootTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
class TestProductServiceImpl extends ProductsServiceImpl {
	@Autowired
	ProductsRepository productsRepository;
	
	static Products product = new Products();
	static List<Orders> orders;

	//Set up product instance
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		product.setId(1L);
		product.setName("Cake");
		product.setDescription("A cake.");
	}

	//Tests to see if repo returns product by id provided
	
	@Test
	void testFindByid() {
		productsRepository.save(product);
		Assert.assertNotNull(productsRepository.findByid(product.getId()));
	}
}