package org.cjwilliams.commonscents.repository;

import org.cjwilliams.commonscents.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA repository for Users

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByEmail(String email);
}