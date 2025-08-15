package com.weather.web.project.weather.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "location")
public class LocationEntity {
    @Id
    @SequenceGenerator(name = "locationSequence", sequenceName = "location_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationSequence")
    @Column(name = "id", nullable = false)
    private Long id;
    private String locationName;
    private String latitude ;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public UserInfoEntity getUser() {
        return user;
    }

    public void setUser(UserInfoEntity user) {
        this.user = user;
    }
}
