package net.javaguides.springannotations.config;

import net.javaguides.springannotations.controller.PizzaController;
import net.javaguides.springannotations.service.MeatPizza;
import net.javaguides.springannotations.service.Pizza;
import net.javaguides.springannotations.service.VegePizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Pizza vegePizza() {
        return new VegePizza();
    }

    @Bean
    public Pizza meatPizza() {
        return new MeatPizza();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public PizzaController pizzaController() {
        return new PizzaController(meatPizza());
    }
}
