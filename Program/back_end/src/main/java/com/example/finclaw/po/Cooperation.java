package com.example.finclaw.po;

public class Cooperation {
    private Integer cooperationID;
    private String cooperationName;
    private String phoneNumber;
    private String ipAddress;
    private String serviceName;
    private String servicePassword;

    public Integer getCooperationID() {
        return cooperationID;
    }

    public void setCooperationID(Integer cooperationID) {
        this.cooperationID = cooperationID;
    }

    public String getCooperationName() {
        return cooperationName;
    }

    public void setCooperationName(String cooperationName) {
        this.cooperationName = cooperationName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServicePassword() {
        return servicePassword;
    }

    public void setServicePassword(String servicePassword) {
        this.servicePassword = servicePassword;
    }
}
