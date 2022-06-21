package org.cjwilliams.commonscents.repository;

import org.cjwilliams.commonscents.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//JPA repository for Payment

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	@Query("FROM Payment LEFT JOIN Users ON Payment.userID = Users.id WHERE Payment.userID = ?1")
	Payment findPaymentByuserID(long id);
}