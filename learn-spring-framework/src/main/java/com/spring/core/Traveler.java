package com.spring.core;

public class Traveler {
   Bike bike;
    public Traveler() {
        this.bike = new Bike();
    }

    public void startJourney() {
        this.bike.move();
    }
}
