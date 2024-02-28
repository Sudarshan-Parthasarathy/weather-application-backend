package com.weather.weatherapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    @RequestMapping("/home")
    public String home() {
        return "This is home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
