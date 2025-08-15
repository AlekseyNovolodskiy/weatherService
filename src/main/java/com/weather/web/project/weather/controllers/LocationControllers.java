package com.weather.web.project.weather.controllers;

import com.weather.web.project.weather.service.LocationService;
import com.weather.web.project.weather.service.implement.LocationServiceDisplay;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationControllers {

    private final LocationService locationService;
    private final LocationServiceDisplay locationServiceDisplay;

    @PostMapping("/add")
    public String addLocation(String latitude, String longitude, String locationName, Model model, HttpServletRequest request) {
        String resultAddLocation = locationService.addLocation(latitude, longitude, locationName, model, request);
        return "weather-page";
    }

    @GetMapping("/weather")
    public String weatherDisplay(Model model, HttpServletRequest request) {
        return locationServiceDisplay.weatherDisplay(model, request);
    }
}

