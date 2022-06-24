package org.cjwilliams.commonscents.test.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.model.Products;
import org.cjwilliams.commonscents.model.Role;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.repository.OrderRepository;
import org.cjwilliams.commonscents.service.OrderServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//Test class for OrderServiceImpl

@SpringBootTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
class TestOrderServiceImpl extends OrderServiceImpl {
	@Autowired
	OrderRepository orderRepository;
	
	static Orders order = new Orders();
	static Users user = new Users();
	static Products product = new Products();
	static Date date = new Date();
	static Collection<Role> roles;
	static List<Orders> orders; 
	
	//Set up instances of orders, products, and users
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		order.setId(1L);
		order.setAddress("1 main st");
		order.setCity("Cityville");
		order.setOrderDate(date);
		order.setState("MA");
		order.setZip(12345);
		order.setProducts(product);
		order.setUsers(user);
		product.setId(2L);
		product.setName("Cake");
		product.setDescription("A cake.");
		user.setId(1L);
		user.setFirstName("Bob");
		user.setLastName("Boy");
		user.setEmail("bob@email");
		user.setPassword("aaaaaaA1");
		user.setRoles(roles);
		user.setOrders(orders);
	}

	//Test save of order to repo
	
	@Test
	void testSave() {
		Assert.assertNotNull(orderRepository.save(order));
	}
}