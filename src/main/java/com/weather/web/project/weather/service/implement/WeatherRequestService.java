package com.weather.web.project.weather.service.implement;

import com.weather.web.project.weather.model.weatherDto.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class WeatherRequestService {
    private final RestTemplate restTemplate;

    public WeatherRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${key}")
    private String apiKey;


    public Double requestMethod(String latitude, String longitude) {

        Root request = restTemplate.exchange(String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s&units=metric", latitude, longitude,apiKey),
                HttpMethod.GET,
                new HttpEntity<>(null, null),
                Root.class).getBody();

        return request.getMain().getTemp();
    }
}
