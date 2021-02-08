package com.example.finclaw.po;

public class  ServerInfo {
    private Integer serverInfoID;//一台服务器只能用一个ID参与一个项目，所以要用serverInfoID来标识
    private Integer userID;
    private Integer projectID;
    private String ipAddress;
    private String serverName;
    private String serverPassword;
    private String filePath;

    public Integer getServerInfoID() {
        return serverInfoID;
    }

    public void setServerInfoID(Integer serverInfoID) {
        this.serverInfoID = serverInfoID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerPassword() {
        return serverPassword;
    }

    public void setServerPassword(String serverPassword) {
        this.serverPassword = serverPassword;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
