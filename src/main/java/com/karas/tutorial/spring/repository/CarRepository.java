package com.karas.tutorial.spring.repository;

import com.karas.tutorial.spring.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

}