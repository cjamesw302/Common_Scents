package org.cjwilliams.commonscents.repository;

import org.cjwilliams.commonscents.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//JPA repository for Users

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	//Returns user by corresponding email(unique field)
	@Query("FROM Users u WHERE u.email = :email")
	Users findByEmail(@Param("email")String email);
}