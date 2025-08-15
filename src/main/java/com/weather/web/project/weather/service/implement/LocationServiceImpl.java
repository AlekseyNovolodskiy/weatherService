package com.weather.web.project.weather.service.implement;

import com.weather.web.project.weather.entity.LocationEntity;
import com.weather.web.project.weather.entity.UserInfoEntity;
import com.weather.web.project.weather.repository.LocationRepository;
import com.weather.web.project.weather.repository.UserRepository;
import com.weather.web.project.weather.service.LocationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    @Override
    public String addLocation(String latitude, String longitude, String locationName, Model model, HttpServletRequest request) {


        String username = (String) request.getAttribute("currentUser");
        if (username == null) {
            throw new RuntimeException("Пользователь не авторизован");
        }

        UserInfoEntity byLogin = userRepository.findByLogin(username);


        List<LocationEntity> byUser = locationRepository.findByUser(byLogin);
        if (byUser.size() >= 5) {
            return "weather-display";
        }
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setLocationName(locationName);
        locationEntity.setLatitude(latitude);
        locationEntity.setLongitude(longitude);
        locationEntity.setUser(byLogin);
        locationRepository.save(locationEntity);

        String firstLocationName = "";
        String secondLocationName = "";
        String thirdLocationName = "";
        String fourthLocationName = "";


        for (int i = 0; i < byUser.size(); i++) {
            LocationEntity locationEntityI = byUser.get(i);
            if (i == 0) {
                firstLocationName = locationEntityI.getLocationName();
            }
            if (i == 1) {
                secondLocationName = locationEntityI.getLocationName();
            }
            if (i == 2) {
                thirdLocationName = locationEntityI.getLocationName();
            }
            if (i == 3) {
                fourthLocationName = locationEntityI.getLocationName();
            }

        }

        model.addAttribute("locationCount", byUser.size() + 1);
        model.addAttribute("LocationName", locationName);

        model.addAttribute("firstLocationName", firstLocationName);
        model.addAttribute("secondLocationName", secondLocationName);
        model.addAttribute("thirdLocationName", thirdLocationName);
        model.addAttribute("fourthLocationName", fourthLocationName);

        return "weather-page";

    }
}
