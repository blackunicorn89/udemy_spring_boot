package com.spring.core;

public class Traveler {
    Car car = null;
    public Traveler() {
        this.car = new Car();
    }

    public void startJourney() {
        this.car.move();
    }
}
