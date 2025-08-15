package com.weather.web.project.weather.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface LocationService {
    String addLocation (String latitude, String longitude, String locationName, Model model, HttpServletRequest request);

}
