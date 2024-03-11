package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
   /* Returns the found product entry by using its name as search criteria. If no product entry is found, this
   method returns null */
    public Product findByName(String name);

    /* Returns an Optional which contains the found product entry by using its id as search criteria. If no product entry is found, this
  method an empty Optional */
    Optional<Product> findById(Long id);

    /*Returns the found list of product entries whose name or description is given
    * as a method parameter. If no product entries is found, this method returns an empty list*/
    List<Product>findByNameOrDescription(String name, String description);

  /*Returns the found list of product entries whose name and description is given
   * as a method parameter. If no product entries is found, this method returns an empty list*/

 List<Product>findByNameAndDescription(String name, String description);

 /*Return the distinct product whose name is given as a method parameter.
 * If no product empty is found, this method returns null. */
 Product findDistinctByName(String name);

 /*Return the products whose price is greater than given price as method parameter*/
 List<Product> findByPriceGreaterThan(BigDecimal price);

 /*Return the products whose price is less than given price as method parameter*/
 List<Product> findByPriceLessThan(BigDecimal price);

 /*Return the filtered list of the products that matches the given text*/
 List<Product> findByNameContaining(String name);

 /*Return products based on SQL like condition*/
 List<Product> findByNameLike(String name);

 /*Query method to find or retrieve products based on the price range (start price and end price*/
 List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

 /*Query method to find or retrieve products based on the created date range (start date and end date*/
 List<Product> findByDateCratedBetween(LocalDateTime startDate, LocalDateTime endDate);

 //Returns list of products based multiple values
 List <Product>findByNameIn(List<String> names);

 List<Product> findFirst4ByOrderByNameAsc();

 List<Product>findTop3ByOrderByPriceDesc();



}
