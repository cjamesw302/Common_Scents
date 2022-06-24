package org.cjwilliams.commonscents.test.repository;

import java.util.Collection;
import java.util.List;
import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.model.Role;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//Test class for UserRepository

@DataJpaTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestUserRepositories {
	@Autowired
	UserRepository userRepository;

	static Users user = new Users();
	static Collection<Role> roles;
	static List<Orders> orders;

	//Set up instance of user
	
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

	//Test to see if repo can find user by email provided
	
	@Test
	void testFindByEmail() {
		userRepository.save(user);
		Assert.assertNotNull(userRepository.findByEmail("bob@email"));
	}
}