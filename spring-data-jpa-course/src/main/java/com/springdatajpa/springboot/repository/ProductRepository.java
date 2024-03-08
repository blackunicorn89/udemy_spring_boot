package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
   /* Returns the found product entry by using its name as search criteria. If no product entry is found, this
   method returns null */
    public Product findByName(String name);

    /* Returns an Optional which contains the found product entry by using its id as search criteria. If no product entry is found, this
  method an empty Optional */
    Optional<Product> findById(Long id);

}
