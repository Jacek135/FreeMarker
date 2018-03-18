package com.karas.tutorial.spring.model;

import com.karas.tutorial.spring.entity.Car;

public class CarDto {

    private String make;
    private String model;
    private Long year;

    public CarDto() {
    }

    public CarDto(String make, String model, Long year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public CarDto(Car car) {
        this.make = car.getMake();
        this.model = car.getModel();
        this.year = car.getYear();
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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }
}