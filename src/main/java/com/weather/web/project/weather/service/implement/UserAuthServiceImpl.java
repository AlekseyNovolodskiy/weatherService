package com.weather.web.project.weather.service.implement;

import com.weather.web.project.weather.entity.UserInfoEntity;
import com.weather.web.project.weather.repository.UserRepository;
import com.weather.web.project.weather.service.UserAuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;

import static java.util.Objects.isNull;
@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;


    @Override
    public String registrationUser(String firstName, String lastName, String login, String password) {
        UserInfoEntity user = userRepository.findByFirstnameAndLastname(firstName, lastName);
        UserInfoEntity byLogin = userRepository.findByLogin(login);
        if (!isNull(user)) {
            return "reg-exception";
        }
        if(!isNull(byLogin)){
            return "reg-exception";
        }
        UserInfoEntity usersEntity = new UserInfoEntity();
        usersEntity.setFirstname(firstName);
        usersEntity.setLastname(lastName);
        usersEntity.setLogin(login);
        usersEntity.setPassword(password);
        userRepository.save(usersEntity);

        return "auth";
    }

    @Override
    public String authUser(String login, String password, HttpServletResponse response) {
        UserRepository byLoginAndPassword = userRepository.findByLoginAndPassword(login, password);
        if(!isNull(byLoginAndPassword)){
            Cookie authCookie = new Cookie("AUTH_TOKEN", generateToken(login));
            authCookie.setPath("/");
            authCookie.setMaxAge(24 * 60 * 60 * 7); // 1 день
            response.addCookie(authCookie);
            return "weather-page";
        }
        return "reg-exception";
    }
    private String generateToken(String login) {

        return Base64.getEncoder()
                .encodeToString((login + ":" + System.currentTimeMillis()).getBytes());
    }
}
