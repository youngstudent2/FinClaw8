package com.example.finclaw.vo.project;

import java.sql.Timestamp;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
public class ProjectForm {
    private String projectName;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;

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
}
