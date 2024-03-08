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

        // Product 1
        Product product1 = new Product();
        product1.setName("Korean Matalan Gurun Oppikirja");
        product1.setDescription("Opi Korean perusteet Jane Matalagurun johdolla");
        product1.setSku("161abs");
        product1.setPrice(new BigDecimal(300));
        product1.setActive(true);
        product1.setImageUrl("kirja.jpg");

// Product 2
        Product product2 = new Product();
        product2.setName("Advanced Java Programming");
        product2.setDescription("Master advanced Java concepts with expert guidance");
        product2.setSku("162bcs");
        product2.setPrice(new BigDecimal(450));
        product2.setActive(true);
        product2.setImageUrl("java_advanced.jpg");

// Product 3
        Product product3 = new Product();
        product3.setName("French Cuisine Essentials");
        product3.setDescription("Discover the secrets of French cooking with this comprehensive guide");
        product3.setSku("163cft");
        product3.setPrice(new BigDecimal(350));
        product3.setActive(true);
        product3.setImageUrl("french_cuisine.jpg");

// Product 4
        Product product4 = new Product();
        product4.setName("The Art of Digital Photography");
        product4.setDescription("Explore the art and techniques of digital photography with this detailed manual");
        product4.setSku("164dgh");
        product4.setPrice(new BigDecimal(500));
        product4.setActive(true);
        product4.setImageUrl("digital_photography.jpg");

// Product 5
        Product product5 = new Product();
        product5.setName("Essentials of Gardening");
        product5.setDescription("Grow your own garden with tips and tricks from the experts");
        product5.setSku("165ehi");
        product5.setPrice(new BigDecimal(220));
        product5.setActive(true);
        product5.setImageUrl("gardening_essentials.jpg");

// Product 6
        Product product6 = new Product();
        product6.setName("Yoga for Beginners");
        product6.setDescription("Start your yoga journey with this beginner-friendly guide");
        product6.setSku("166fjk");
        product6.setPrice(new BigDecimal(280));
        product6.setActive(true);
        product6.setImageUrl("yoga_beginners.jpg");

        // Product 7
        Product product7 = new Product();
        product7.setName("Italian Language Fundamentals");
        product7.setDescription("Learn Italian from the ground up with this interactive course");
        product7.setSku("167glp");
        product7.setPrice(new BigDecimal(320));
        product7.setActive(true);
        product7.setImageUrl("italian_language.jpg");

// Product 8
        Product product8 = new Product();
        product8.setName("DIY Home Repairs");
        product8.setDescription("Become a home repair expert with practical, step-by-step instructions");
        product8.setSku("168hmq");
        product8.setPrice(new BigDecimal(400));
        product8.setActive(true);
        product8.setImageUrl("diy_home.jpg");

// Product 9
        Product product9 = new Product();
        product9.setName("Ultimate Guide to Baking");
        product9.setDescription("Bake like a pro with recipes and tips from master bakers");
        product9.setSku("169inr");
        product9.setPrice(new BigDecimal(375));
        product9.setActive(true);
        product9.setImageUrl("baking_guide.jpg");

// Product 10
        Product product10 = new Product();
        product10.setName("Mastering Chess Strategies");
        product10.setDescription("Improve your chess game with strategies from grandmasters");
        product10.setSku("170jos");
        product10.setPrice(new BigDecimal(250));
        product10.setActive(true);
        product10.setImageUrl("chess_strategies.jpg");


        productRepository.saveAll(List.of(product, product1, product2, product3, product4, product5, product6, product7, product8, product9, product10));
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