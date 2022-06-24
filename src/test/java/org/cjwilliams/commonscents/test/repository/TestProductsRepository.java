package org.cjwilliams.commonscents.test.repository;

import java.util.List;
import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.model.Products;
import org.cjwilliams.commonscents.repository.ProductsRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//Test class for ProductsRepository

@DataJpaTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestProductsRepository {
	@Autowired
	ProductsRepository productsRepository;
	
	static Products product = new Products();
	static List<Orders> orders;

	//Set up instance of products
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		product.setId(1L);
		product.setName("Cake");
		product.setDescription("A cake.");
	}

	//Test to see if repo returns product by id provided
	
	@Test
	void testFindByid() {
		productsRepository.save(product);
		Assert.assertNotNull(productsRepository.findByid(product.getId()));
	}
}