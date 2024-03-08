package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void SaveMethod() {
//        create product
        Product product = new Product();
        product.setName("Villakoiraimuri");
        product.setDescription("Hyvä imemään villakoiria nurkista ja taluttajien hihnoista");
        product.setSku("159abs");
        product.setPrice(new BigDecimal(1923));
        product.setActive(true);
        product.setImageUrl("villis.jpg");

//        save product
        Product savedProduct = productRepository.save(product);
//        display product info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }
    @Test
    void updateUsingSaveMethod() {
        //find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity information
        product.setName("Päivitetty villakoiraimuri");
        product.setDescription("Ei hyydy ylämäkeen ja parannettu imutehoa");

        //save updated entity
        productRepository.save(product);

    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product);
    }

    @Test
    void SaveAllMethod() {
        Product product = new Product();
        product.setName("Yarunon ihmelitku");
        product.setDescription("Puhdistaa nuudelit ja kypärät ihmehajuista");
        product.setSku("160abs");
        product.setPrice(new BigDecimal(19));
        product.setActive(true);
        product.setImageUrl("litku.jpg");

        Product product1 = new Product();
        product1.setName("Korean matalan gurun oppikirja");
        product1.setDescription("Opi korean perusteet Jane Matalagurun johdolla");
        product1.setSku("161abs");
        product1.setPrice(new BigDecimal(300));
        product1.setActive(true);
        product1.setImageUrl("kirja.jpg");

        productRepository.saveAll(List.of(product, product1));
    }
    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName() + " " + p.getDescription());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {

        // find an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        //delete(entity)
        productRepository.delete(product);

    }
    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
    }

    @Test
    void deleteAllMethodWithListOfObjects(){
        Product product = productRepository.findById(7L).get();
        Product product1 = productRepository.findById(9L).get();

        productRepository.deleteAll(List.of(product, product1));

    }

    @Test
    void countMethod() {
        long rows;
        rows = productRepository.count();
        System.out.println(rows);
    }

    @Test
    void existByIdMethod() {
        boolean exist1 = productRepository.existsById(1L);
        boolean exist8 = productRepository.existsById(8L);

        System.out.println("Product with the id 1 exists: " + exist1);
        System.out.println("Product with the id 8 exists: " + exist8);
    }

}