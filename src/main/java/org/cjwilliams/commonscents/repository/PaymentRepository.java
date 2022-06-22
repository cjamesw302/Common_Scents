package org.cjwilliams.commonscents.repository;

import org.cjwilliams.commonscents.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//JPA repository for Payment

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	//Selects the userID only from payment where its equal to the userID from the active user 
	@Query("SELECT p.users.id FROM Payment p LEFT JOIN Users u ON p.users.id = u.id WHERE p.users.id = :userID")
	Long findPaymentByuserID(@Param("userID") Long userID);
}