package org.cjwilliams.commonscents.controller;

import javax.validation.Valid;
import org.cjwilliams.commonscents.dto.UserRegistrationDto;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//User registration controller that saves order data to database

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

   @Autowired
   private UserService userService;

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
}