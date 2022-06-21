package org.cjwilliams.commonscents.repository;

import org.cjwilliams.commonscents.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA repository for Orders

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {}