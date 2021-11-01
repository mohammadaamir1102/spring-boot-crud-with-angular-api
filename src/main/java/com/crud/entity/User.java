package com.crud.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;
    private String userName;
    private String userFatherName;
    private String userMobile;
    private String userAddress;
    private String userEmail;
    private String password;


    public User() {
    }

    public User(Long userId, String userName, String userFatherName, String userMobile, String userAddress, String userEmail, String password) {
        UserId = userId;
        this.userName = userName;
        this.userFatherName = userFatherName;
        this.userMobile = userMobile;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.password = password;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFatherName() {
        return userFatherName;
    }

    public void setUserFatherName(String userFatherName) {
        this.userFatherName = userFatherName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", userName='" + userName + '\'' +
                ", userFatherName='" + userFatherName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
