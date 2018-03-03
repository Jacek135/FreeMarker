package com.boraji.turtorial.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String seyHello(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("carList", "Hello Spring MVC");

        return "index";
    }
}