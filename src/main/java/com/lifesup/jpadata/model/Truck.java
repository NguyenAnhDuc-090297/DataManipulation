package com.lifesup.jpadata.model;

public class Truck extends Vehicle {
    private Integer wheel;

    @Override
    public Integer calculate() {
        return this.wheel;
    }
}
