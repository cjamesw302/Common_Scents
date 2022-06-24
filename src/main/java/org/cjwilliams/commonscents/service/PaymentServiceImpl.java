package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.dto.PaymentRegistrationDto;
import org.cjwilliams.commonscents.model.Payment;
import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//Implementation of payment service

@Service
@Lazy
public class PaymentServiceImpl implements PaymentService {
	@Autowired
    private PaymentRepository paymentRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	UserService userService;

	//Saves gets and sets current order details to database
	
    @Override
    public Payment save(PaymentRegistrationDto registration){
        Payment payment = new Payment();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String login = authentication.getName();
    	Users user = userService.findByEmail(login);
        payment.setFullName(registration.getFullName());
        payment.setEmail(registration.getEmail());        
        payment.setAddress(registration.getAddress());
        payment.setCity(registration.getCity());
        payment.setState(registration.getState());
        payment.setZip(registration.getZip());
        payment.setCardName(registration.getCardName());
        payment.setCardNumber(encoder.encode(registration.getCardNumber()));
        payment.setExpMonth(registration.getExpMonth());
        payment.setExpYear(registration.getExpYear());
        payment.setCvv(registration.getCvv());
        payment.setUsers(user);
        return paymentRepository.save(payment);
    }
}