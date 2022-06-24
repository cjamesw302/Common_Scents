package org.cjwilliams.commonscents.service;

import org.cjwilliams.commonscents.dto.PaymentRegistrationDto;
import org.cjwilliams.commonscents.model.Payment;

//Interface for payment service

public interface PaymentService{
	//Saves gets and sets current payment details to database
    Payment save(PaymentRegistrationDto payment);
}