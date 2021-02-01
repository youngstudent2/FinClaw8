package com.example.finclaw.vo.account;


import com.example.finclaw.enums.UserType;

public class UserVO {
    private Integer userID;
    private String email;
    private String password;
    private String username;
    private String phoneNumber;
    private UserType role;
    private String cooperation;
    private Integer cooperationID;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    public Integer getCooperationID() {
        return cooperationID;
    }

    public void setCooperationID(Integer cooperationID) {
        this.cooperationID = cooperationID;
    }
}
