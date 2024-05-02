package net.javaguides.springannotations.service;

import org.springframework.stereotype.Component;

@Component
public class VegePizza implements Pizza{

    @Override
    public String getPizza() {
        return "Vege Pizza";
    }
}
