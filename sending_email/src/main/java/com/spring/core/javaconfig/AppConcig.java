package com.spring.core.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.core")
public class AppConcig {
    @Bean
    public DataSource mysqlDataSource() {
        return new MySQLDataSource();
    }

    @Bean
    public DataSource postgesqlDataSource() {
        return new PostgreSQLDataSource();
    }

    @Bean
    public EmailService emailService() {
        return new EmailService(postgesqlDataSource());
    }
}
