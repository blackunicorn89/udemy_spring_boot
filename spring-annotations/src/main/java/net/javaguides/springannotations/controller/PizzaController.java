package net.javaguides.springannotations.controller;

import net.javaguides.springannotations.service.Pizza;
import net.javaguides.springannotations.service.VegePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class PizzaController {

    private Pizza pizza;

    @Autowired
    public PizzaController(Pizza pizza) {
        this.pizza = pizza;
    }

//    @Autowired
//    public PizzaController(@Qualifier("meatPizza") Pizza pizza) {
//        this.pizza = pizza;
//    }

//    @Autowired
//    public void setVegePizza(VegePizza vegePizza) {
//        this.vegePizza = vegePizza;
//    }

    public String GetPizza() {
        return pizza.getPizza();
    }

    public void init() {
        System.out.println("(initialization logic) Making pizza");
    }

    public void destroy() {
        System.out.println("(Destroy logic) Eating pizza");
    }
}
