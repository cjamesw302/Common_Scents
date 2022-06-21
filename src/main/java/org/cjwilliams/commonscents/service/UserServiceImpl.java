package org.cjwilliams.commonscents.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.cjwilliams.commonscents.dto.UserRegistrationDto;
import org.cjwilliams.commonscents.model.Role;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

   //finds user by email
   
   @Override
   public Users findByEmail(String email){
       return userRepository.findByEmail(email);
   }
   
   //saves user data to database
   
   @Override
   public Users save(UserRegistrationDto registration){
       Users user = new Users();
       user.setFirstName(registration.getFirstName());
       user.setLastName(registration.getLastName());
       user.setEmail(registration.getEmail());
       user.setPassword(passwordEncoder.encode(registration.getPassword()));
       user.setRoles(Arrays.asList(new Role("ROLE_USER")));
       return userRepository.save(user);
   }
   
   //returns user by their username
   
   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Users user = userRepository.findByEmail(email);
       if (user == null){
           throw new UsernameNotFoundException("Invalid username or password.");
       }
       return new org.springframework.security.core.userdetails.User(user.getEmail(),
               user.getPassword(),
               mapRolesToAuthorities(user.getRoles()));
   }
   
   //authenticates the user by providing them a role
   
   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
       return roles.stream()
               .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toList());
   }
}