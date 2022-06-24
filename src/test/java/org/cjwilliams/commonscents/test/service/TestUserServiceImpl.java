package org.cjwilliams.commonscents.test.service;

import java.util.Collection;
import java.util.List;
import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.model.Role;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.repository.UserRepository;
import org.cjwilliams.commonscents.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
class TestUserServiceImpl extends UserServiceImpl {
	@Autowired
	UserRepository userRepository;

	static Users user = new Users();
	static Collection<Role> roles;
	static List<Orders> orders;

	//Set up user instance
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		user.setId(1L);
		user.setFirstName("Bob");
		user.setLastName("Boy");
		user.setEmail("bob@email");
		user.setPassword("aaaaaaA1");
		user.setRoles(roles);
		user.setOrders(orders);
	}

	//Test save of user to repo
	
	@Test
	void testSave() {
		Assert.assertNotNull(userRepository.save(user));
	}
}