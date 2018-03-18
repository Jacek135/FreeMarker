package com.karas.tutorial.spring.controller;

import com.karas.tutorial.spring.facade.CarFacade;
import com.karas.tutorial.spring.model.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

    private static final String CARS = "redirect:/cars";
    private CarFacade facade;

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
        model.addAttribute("carList", facade.findAllCars());

        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") CarDto carDto) {
        if (null != carDto && null != carDto.getMake() && null != carDto.getModel()
                && !carDto.getMake().isEmpty() && !carDto.getModel().isEmpty()) {
            facade.saveCar(carDto);
        }
        return CARS;
    }
}