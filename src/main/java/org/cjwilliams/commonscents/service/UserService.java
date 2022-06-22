package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.dto.UserRegistrationDto;
import org.cjwilliams.commonscents.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

//Interface for users service

public interface UserService extends UserDetailsService {
	//Returns user by corresponding email(unique field) 
    Users findByEmail(String email);
    //Gets and sets current user details to database
    Users save(UserRegistrationDto registration);
}