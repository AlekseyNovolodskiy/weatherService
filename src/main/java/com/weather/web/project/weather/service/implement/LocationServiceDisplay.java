package com.weather.web.project.weather.service.implement;

import com.weather.web.project.weather.entity.LocationEntity;
import com.weather.web.project.weather.entity.UserInfoEntity;
import com.weather.web.project.weather.repository.LocationRepository;
import com.weather.web.project.weather.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceDisplay {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final WeatherRequestService weatherRequestService;

    public String weatherDisplay(Model model, HttpServletRequest request) {
        String username = (String) request.getAttribute("currentUser");
        if (username == null) {
            throw new RuntimeException("Пользователь не авторизован");
        }
        UserInfoEntity byLogin = userRepository.findByLogin(username);
        List<LocationEntity> byUser = locationRepository.findByUser(byLogin);
        String firstLocationName = "";
        String secondLocationName = "";
        String thirdLocationName = "";
        String fourthLocationName = "";
        String fifthLocationName = "";
        Double firstLocationTemp = null;
        Double secondLocationTemp = null;
        Double thirdLocationTemp = null;
        Double fourthLocationTemp = null;
        Double fifthLocationTemp = null;

        for (int i = 0; i < byUser.size(); i++) {
            LocationEntity locationEntityI = byUser.get(i);
            if (i == 0) {
                firstLocationName = locationEntityI.getLocationName();

                firstLocationTemp = weatherRequestService.requestMethod(locationEntityI.getLatitude(), locationEntityI.getLongitude());
            }
            if (i == 1) {
                secondLocationName = locationEntityI.getLocationName();

                secondLocationTemp = weatherRequestService.requestMethod(locationEntityI.getLatitude(), locationEntityI.getLongitude());
            }
            if (i == 2) {
                thirdLocationName = locationEntityI.getLocationName();

                thirdLocationTemp = weatherRequestService.requestMethod(locationEntityI.getLatitude(), locationEntityI.getLongitude());
            }
            if (i == 3) {
                fourthLocationName = locationEntityI.getLocationName();

                fourthLocationTemp = weatherRequestService.requestMethod(locationEntityI.getLatitude(), locationEntityI.getLongitude());
            }
            if (i == 4) {
                fifthLocationName = locationEntityI.getLocationName();

                fifthLocationTemp = weatherRequestService.requestMethod(locationEntityI.getLatitude(), locationEntityI.getLongitude());
            }
        }

        model.addAttribute("firstLocationName", firstLocationName);
        model.addAttribute("secondLocationName", secondLocationName);
        model.addAttribute("thirdLocationName", thirdLocationName);
        model.addAttribute("fourthLocationName", fourthLocationName);
        model.addAttribute("fifthLocationName", fifthLocationName);
        model.addAttribute("firstLocationTemp",firstLocationTemp);
        model.addAttribute("secondLocationTemp",secondLocationTemp);
        model.addAttribute("thirdLocationTemp",thirdLocationTemp);
        model.addAttribute("fourthLocationTemp",fourthLocationTemp);
        model.addAttribute("fifthLocationTemp",fifthLocationTemp);

        return "weather-display";
    }

}
