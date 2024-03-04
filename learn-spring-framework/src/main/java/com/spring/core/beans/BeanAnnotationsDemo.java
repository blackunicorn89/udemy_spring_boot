package com.spring.core.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student {
    private Address address;

    public Student(Address address) {
        this.address = address;
    }

    public void print() {
        System.out.println("Student class method called...");
        address.print();
    };

    public void init() {
        System.out.println("Student bean init");
    }

    public void destroy() {
        System.out.println("Student bean destroy");
    }
}

class Address {
    public void print() {
        System.out.println("Address class method called...");
    };
}

public class BeanAnnotationsDemo {
    public static void main(String[] args) {
        try (var applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)){

            Student student = (Student) applicationContext.getBean("StudentBean");
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            for (String bean : beanNames) {
                System.out.println(bean);
            }
            student.print();
        }
    }
}

@Configuration
class AppConfig {
    @Bean("AddressBean")
    public Address address() {
        return new Address();
    }

    @Bean(name = "StudentBean", initMethod = "init", destroyMethod = "destroy")
    public Student student() {
        return new Student(address());
    }

}
