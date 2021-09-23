package de.restoba.terminverwaltungservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private String userPasswort;

    private String userRolle;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswort() {
        return userPasswort;
    }

    public void setUserPasswort(String userPasswort) {
        this.userPasswort = userPasswort;
    }

    public String getUserRolle() {
        return userRolle;
    }

    public void setUserRolle(String userRolle) {
        this.userRolle = userRolle;
    }
}