package com.weather.web.project.weather.model.weatherDto;

import lombok.Data;

@Data
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
