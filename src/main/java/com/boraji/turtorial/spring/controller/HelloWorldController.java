package com.boraji.turtorial.spring.controller;

import com.boraji.turtorial.spring.facade.CarFacade;
import com.boraji.turtorial.spring.model.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {

    private static final String CARS = "redirect:/cars";
    private static List<CarDto> carDtoList = new ArrayList<>();
    private CarFacade facade;

    static {
        carDtoList.add(new CarDto("Honda", "Civic"));
        carDtoList.add(new CarDto("Toyota", "Camry"));
        carDtoList.add(new CarDto("Nissan", "Altima"));
    }

    @Autowired
    public HelloWorldController(CarFacade facade) {
        this.facade = facade;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return CARS;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String seyHello(@ModelAttribute("model") ModelMap model) {
//        model.addAttribute("carList", carDtoList);
        model.addAttribute("carList", facade.findAllCars());

        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") CarDto carDto) {
        if (null != carDto && null != carDto.getMake() && null != carDto.getModel()
                && !carDto.getMake().isEmpty() && !carDto.getModel().isEmpty()) {
            carDtoList.add(carDto);
        }
        return CARS;
    }

}