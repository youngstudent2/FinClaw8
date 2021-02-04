package com.example.finclaw.po;

import com.example.finclaw.enums.ProjectStatus;

import java.sql.Timestamp;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
public class Project {
    private Integer projectID;
    private Integer userID;
    private Integer modelID;
    private String projectName;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
    private ProjectStatus status;

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
