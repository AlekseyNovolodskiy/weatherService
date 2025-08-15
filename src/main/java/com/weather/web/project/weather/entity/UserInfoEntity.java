package com.weather.web.project.weather.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "user_info")
@NoArgsConstructor
public class UserInfoEntity {
    @Id
    @SequenceGenerator(name = "user_infoSequence", sequenceName = "user_info_sequence", initialValue = 3, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_infoSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    private String login;
    private String firstname;
    private String lastname;
    private String password;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LocationEntity> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<LocationEntity> getUser() {
        return user;
    }

    public void setUser(List<LocationEntity> user) {
        this.user = user;
    }
}
