package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("Yarunon ihmelitku");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println(product);
    };

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(15L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println(product);
    };

    @Test
    void findByNameOrDescription() {
        List<Product>products = productRepository.findByNameOrDescription("Yarunon ihmelitku", "Opi Korean perusteet Jane Matalagurun johdolla");
        for (Product product: products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        }
    }

    @Test
    void findByNameAndDescription() {
        List<Product>products = productRepository.findByNameAndDescription("French Cuisine Essentials", "Discover the secrets of French cooking with this comprehensive guide");
        for (Product product: products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        }
    }

        @Test
        void findDistinctByName() {
            Product product = productRepository.findDistinctByName("Essentials of Gardening");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        }

        @Test
        void findProductsByPriceLessThan() {
            BigDecimal price = new BigDecimal(300);
            List<Product> products = productRepository.findByPriceLessThan(price);
            for (Product product: products) {
                System.out.println(product.getId());
                System.out.println(product.getName());
                System.out.println(product.getPrice());
                System.out.println(product.getDescription());
            }
        }

        @Test
        void findProductsByNameContaining() {
            List<Product> filteredProducts = productRepository.findByNameContaining("Essentials");
            for (Product product: filteredProducts) {
                System.out.println(product.getId());
                System.out.println(product.getName());
                System.out.println(product.getDescription());
            }
        }

    @Test
    void findProductsByNameLike() {
        List<Product> filteredProducts = productRepository.findByNameLike("French Cuisine Essentials");
        for (Product product: filteredProducts) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());

        }
    }

    @Test
    void findProductsByPriceBetween() {
        List<Product> filteredProducts = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(350));
        for (Product product: filteredProducts) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        }
    }

    @Test
    void findProductsByDateCreated() {
        LocalDateTime startTime = LocalDateTime.of(2024, 3, 1, 23, 59);
        LocalDateTime endTime = LocalDateTime.of(2024, 3, 11, 23, 59);

        List<Product> filteredProducts = productRepository.findByDateCratedBetween(startTime, endTime);
        for (Product product: filteredProducts) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        }
    }

    @Test
    void findProductsByNameIn() {

        List<Product> filteredProducts = productRepository.findByNameIn(List.of("Yarunon ihmelitku", "Essentials of Gardening", "Korean Matalan Gurun Oppikirja"));
        for (Product product: filteredProducts) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        }
    }

    @Test
    void findFirst4ProductsByOrderByNameAsc() {
        List<Product> products = productRepository.findFirst4ByOrderByNameAsc();
        for (Product product: products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        }
    }

    @Test
    void findTop3ProductsByPriceDesc() {
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();
        for (Product product: products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        }
    }



}
