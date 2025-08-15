package com.weather.web.project.weather.service;

import jakarta.servlet.http.HttpServletResponse;

public interface UserAuthService {
    String registrationUser(String firstName, String lastName, String login, String password);
    String authUser(String login, String password, HttpServletResponse response);

}

