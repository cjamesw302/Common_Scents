package org.cjwilliams.commonscents.controller;

import java.util.Arrays;

import javax.validation.Valid;
import org.cjwilliams.commonscents.dto.UserRegistrationDto;
import org.cjwilliams.commonscents.model.Role;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.repository.UserRepository;
import org.cjwilliams.commonscents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;

//User registration controller that saves order data to database

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

   @Autowired
   private UserService userService;
   
   @Autowired
   private UserRepository userRepository;
   
   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

   @ModelAttribute("user")
   public UserRegistrationDto userRegistrationDto() {
       return new UserRegistrationDto();
   }
   
   //Getmapping for registration view
   
   @GetMapping
   public String showRegistrationForm(Model model) {
       return "registration";
   }
   
   //Posts user data to database unless that email is already registered
   
   @PostMapping
   public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){
       Users existing = userService.findByEmail(userDto.getEmail());
       if (existing != null){
           result.rejectValue("email", null, "There is already an account registered with that email");
       }
       if (result.hasErrors()){
           return "registration";
       }
       userService.save(userDto);
       return "redirect:/login?success";
   }
   /*
   
   //Putmapping to update user
   
   @PutMapping
   public Users updateUser(@PathVariable(value = "email") String email, @Valid @RequestBody UserRegistrationDto userDetails){
        Users user = userService.findByEmail(email);
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
   }
   
   //Deletemapping to delete user
   
   @Deletemapping
   public Map<String, Boolean> deleteUser(@PathVariable(value = "email") String email, @Valid @RequestBody UserRegistrationDto userDetails){
        Users user = userService.findByEmail(email);
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
    	response.put("deleted", Boolean.TRUE);
    	return response;
   }
   */
}