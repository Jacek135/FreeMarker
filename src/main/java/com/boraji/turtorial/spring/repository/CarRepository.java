package com.boraji.turtorial.spring.repository;

import com.boraji.turtorial.spring.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

}