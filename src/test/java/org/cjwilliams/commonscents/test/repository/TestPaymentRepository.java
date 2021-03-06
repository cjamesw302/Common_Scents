package org.cjwilliams.commonscents.test.repository;

import java.util.Collection;
import java.util.List;
import org.cjwilliams.commonscents.model.Orders;
import org.cjwilliams.commonscents.model.Payment;
import org.cjwilliams.commonscents.model.Role;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.repository.PaymentRepository;
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

//Test class for PaymentRepository

@DataJpaTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestPaymentRepository {
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	UserRepository userRepository;

	static Users user = new Users();
	static Payment payment = new Payment();
	static Collection<Role> roles;
	static List<Orders> orders;
	
	//Set up instances of user and payment
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		user.setId(1L);
		user.setFirstName("Bob");
		user.setLastName("Boy");
		user.setEmail("bob@email");
		user.setPassword("aaaaaaA1");
		user.setRoles(roles);
		user.setOrders(orders);
		payment.setId(2L);
		payment.setFullName("Bob Boy");
		payment.setEmail("bob@email.com");
		payment.setAddress("1");
		payment.setCity("city");
		payment.setState("MA");
		payment.setZip("12345");
		payment.setCardName("Bob Boy");
		payment.setCardNumber("1111222233334444");
		payment.setExpMonth(01);
		payment.setExpYear(2025);
		payment.setCvv(123);
		payment.setUsers(user);
	}

	//Test to see if repo returns payment based on userID provided
	
	@Test
	void testFindPaymentByuserID() {
		userRepository.save(user);
		paymentRepository.save(payment);
		Assert.assertNotNull(paymentRepository.findPaymentByuserID(user.getId()));
	}
}
