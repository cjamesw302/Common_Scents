package org.cjwilliams.commonscents.repository;

import org.cjwilliams.commonscents.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA repository for Products

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	Products findByid(long id);
}