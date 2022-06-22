package org.cjwilliams.commonscents.repository;

import org.cjwilliams.commonscents.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//JPA repository for Products

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	//finds product by corresponding id
	@Query("FROM Products p WHERE p.id = :id")
	Products findByid(@Param("id")Long id);
}