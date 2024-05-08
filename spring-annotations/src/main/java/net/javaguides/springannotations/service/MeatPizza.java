package net.javaguides.springannotations.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
public class MeatPizza implements Pizza{

    @Override
    public String getPizza() {
        return "Ham pizza";
    }
}
