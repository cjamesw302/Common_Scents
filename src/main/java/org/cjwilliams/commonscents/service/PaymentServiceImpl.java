package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.model.Payment;
import org.cjwilliams.commonscents.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

//Implementation of payment service

@Service
@Lazy
public class PaymentServiceImpl implements PaymentService {
	@Autowired
    private PaymentRepository paymentRepository;

	//Saves gets and sets current order details to database
	
    @Override
    public Payment save(Payment registration){
        Payment payment = new Payment();
        payment.setFullName(registration.getFullName());
        payment.setEmail(registration.getEmail());        
        payment.setAddress(registration.getAddress());
        payment.setCity(registration.getCity());
        payment.setState(registration.getState());
        payment.setZip(registration.getZip());
        payment.setCardName(registration.getCardName());
        payment.setCardNumber(registration.getCardNumber());
        payment.setExpMonth(registration.getExpMonth());
        payment.setExpYear(registration.getExpYear());
        payment.setCvv(registration.getCvv());
        return paymentRepository.save(registration);
    }
}