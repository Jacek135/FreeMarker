package com.karas.tutorial.spring.facade;

import com.karas.tutorial.spring.entity.Car;
import com.karas.tutorial.spring.model.CarDto;
import com.karas.tutorial.spring.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarFacade {

    private final CarsService service;

    @Autowired
    public CarFacade(CarsService service) {
        this.service = service;
    }

    public List<CarDto> findAllCars() {
        List<Car> allCars = service.findAll();
        return allCars.stream()
                .map(e -> {
                    CarDto dto = new CarDto(e);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
