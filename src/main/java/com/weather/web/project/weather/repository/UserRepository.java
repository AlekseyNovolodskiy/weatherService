package com.weather.web.project.weather.repository;

import com.weather.web.project.weather.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfoEntity,Long> {
    UserInfoEntity findByFirstnameAndLastname(String firstName,String lastName);
    UserInfoEntity findByLogin(String login);
    UserRepository findByLoginAndPassword(String login,String password);
}
