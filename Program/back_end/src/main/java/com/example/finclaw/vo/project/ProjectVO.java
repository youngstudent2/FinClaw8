package com.example.finclaw.vo.project;

import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.enums.ProjectStatus;
import com.example.finclaw.po.Project;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
public class ProjectVO {
    private Integer projectID;
    private String projectName;
    private String description;
    private ProjectStatus status;
    private Timestamp startTime;
    private Timestamp endTime;

    public ProjectVO(Project project) {
        BeanUtils.copyProperties(project, this);
    }

    public ProjectVO(){}


    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
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
