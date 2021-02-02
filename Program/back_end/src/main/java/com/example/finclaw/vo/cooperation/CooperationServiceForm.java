package com.example.finclaw.vo.cooperation;

public class CooperationServiceForm {
    private Integer cooperationID;
    private Integer projectID;
    private String ipAddress;
    private String serviceName;
    private String servicePassword;
    private String filepath;

    public Integer getCooperationID() {
        return cooperationID;
    }

    public void setCooperationID(Integer cooperationID) {
        this.cooperationID = cooperationID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
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

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}

