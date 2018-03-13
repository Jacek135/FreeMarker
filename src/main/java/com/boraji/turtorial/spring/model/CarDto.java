package com.boraji.turtorial.spring.model;

import com.boraji.turtorial.spring.entity.Car;

public class CarDto {

    private String make;
    private String model;

    public CarDto() {
    }

    public CarDto(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public CarDto(Car car) {
        this.make = car.getMake();
        this.model = car.getModel();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}