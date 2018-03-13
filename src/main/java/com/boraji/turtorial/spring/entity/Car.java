package com.boraji.turtorial.spring.entity;

import javax.persistence.*;

@Entity
@Table(name= "CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MAKE")
    private String make;

    @Column(name = "MODEL")
    private String model;

    public Car() {
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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