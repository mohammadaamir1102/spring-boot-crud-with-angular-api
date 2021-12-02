package com.crud.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;


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
//    private String fileName;
//    private String fileType;
//    @Lob
//    private byte[] fileData;

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
//        this.fileName = fileName;
//        this.fileType = fileType;
//        this.fileData = fileData;
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

//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getFileType() {
//        return fileType;
//    }
//
//    public void setFileType(String fileType) {
//        this.fileType = fileType;
//    }
//
//    public byte[] getFileData() {
//        return fileData;
//    }
//
//    public void setFileData(byte[] fileData) {
//        this.fileData = fileData;
//    }

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
