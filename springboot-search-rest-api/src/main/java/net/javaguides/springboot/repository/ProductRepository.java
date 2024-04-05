package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

   //If you want to use native SQL syntax make sure the table name is correct, you don't use alias names, and you add "nativeQuery = true" at the end of @Query entity
    @Query("Select p From Product p where " +
    "p.name LIKE CONCAT('%',:query, '%')" +
    "Or p.description LIKE CONCAT('%', :query, '%')")
    List<Product>searchProducts(String query);
}
