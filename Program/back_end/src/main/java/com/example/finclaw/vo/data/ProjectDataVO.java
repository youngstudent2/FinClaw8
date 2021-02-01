package com.example.finclaw.vo.data;

import java.sql.Timestamp;

public class ProjectDataVO {

    private Integer projectID;
    private String name;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
    private String status;
    private Integer fileID;
    private Integer cooperationNumber;


    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCooperationNumber() {
        return cooperationNumber;
    }

    public void setCooperationNumber(Integer cooperationNumber) {
        this.cooperationNumber = cooperationNumber;
    }

    public Integer getFileID() {
        return fileID;
    }

    public void setFileID(Integer fileID) {
        this.fileID = fileID;
    }
}
