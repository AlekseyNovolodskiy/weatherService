package com.weather.web.project.weather.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class RedirectFormControllers {

    @GetMapping("/")
    public String index() {
        log.info("enter into the programm");
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
