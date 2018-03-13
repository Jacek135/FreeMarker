package com.boraji.turtorial.spring.service;

import com.boraji.turtorial.spring.entity.Car;
import com.boraji.turtorial.spring.repository.CarRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    private CarRepository repository;

    @Autowired
    public CarsService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> findAll() {
        Iterable<Car> all = repository.findAll();
        return Lists.newArrayList(all);
    }
}
