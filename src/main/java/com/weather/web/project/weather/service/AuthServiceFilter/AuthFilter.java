package com.weather.web.project.weather.service.AuthServiceFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;



        // Проверяем авторизацию
        String username = extractUsernameFromCookie(httpRequest);
        if(username != null) {
            request.setAttribute("currentUser", username); // Добавляем пользователя в атрибуты
            chain.doFilter(request, response);
        }
    }

    private String extractUsernameFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if("AUTH_TOKEN".equals(cookie.getName())) {
                    return validateAndGetUsername(cookie.getValue());
                }
            }
        }
        return null;
    }

    private String validateAndGetUsername(String token) {
        try {
            String decoded = new String(Base64.getDecoder().decode(token));
            return decoded.split(":")[0]; // Возвращаем только логин
        } catch(Exception e) {
            return null;
        }
    }
}