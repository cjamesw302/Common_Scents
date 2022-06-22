package org.cjwilliams.commonscents.test.service;

import static org.junit.Assert.*;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.service.UserServiceImpl;
import org.junit.Test;

public class TestUserServiceImpl extends UserServiceImpl {
	Users user;
	
	protected void setUp() throws Exception{
		user = new Users(1L, "abc@email.com", "Bob", "Bobby", "abcdefgH1");
	}
	
	@Test
	public void testFindByEmail() {
		assertEquals(user, productsService.findByid(product.getId()));
	}
}