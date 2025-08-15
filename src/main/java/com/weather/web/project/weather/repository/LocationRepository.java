package com.weather.web.project.weather.repository;

import com.weather.web.project.weather.entity.LocationEntity;
import com.weather.web.project.weather.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<LocationEntity,Long> {
    List<LocationEntity> findByUser(UserInfoEntity userInfoEntity);
}
