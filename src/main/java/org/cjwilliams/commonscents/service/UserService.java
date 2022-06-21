package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.dto.UserRegistrationDto;
import org.cjwilliams.commonscents.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

//Interface for users service

public interface UserService extends UserDetailsService {
   Users findByEmail(String email);
   Users save(UserRegistrationDto registration);
}