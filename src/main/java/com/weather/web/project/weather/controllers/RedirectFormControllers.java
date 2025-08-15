package com.weather.web.project.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectFormControllers {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";

    }
    @GetMapping("/autentificate")
    public String showAuthForm() {
        return "auth";

    }
    @GetMapping("/weather-page")
    public String showWeatherForm() {
        return "weather-page";
    }
    @GetMapping("/weather")
    public String showWeatherDisplay() {
        return "weather-diplay";
    }
}
