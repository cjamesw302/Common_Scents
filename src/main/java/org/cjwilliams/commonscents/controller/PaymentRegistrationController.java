package org.cjwilliams.commonscents.controller;

import org.cjwilliams.commonscents.dto.PaymentRegistrationDto;
import org.cjwilliams.commonscents.model.Payment;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.service.PaymentService;
import org.cjwilliams.commonscents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Payment registration controller that saves order data to database

@Controller
@RequestMapping("/payment")
public class PaymentRegistrationController {

	@Autowired
    private PaymentService paymentService;

	@Autowired
	private UserService userService;
	
	//Getmapping for payment view
    @GetMapping
    public String payment(Model model) {
    	Payment payment = new Payment();
    	model.addAttribute("payment", payment);
    	return "payment";
    }
    
    //Posts payment data of current user to database
    
    @PostMapping
    public String updateUserPayment(@ModelAttribute PaymentRegistrationDto payment){
        paymentService.save(payment);
        return "redirect:/home?success";
   }
}