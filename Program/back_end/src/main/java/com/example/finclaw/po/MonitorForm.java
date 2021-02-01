package com.example.finclaw.po;

import com.example.finclaw.enums.Operation;

import java.sql.Time;
import java.sql.Timestamp;

public class MonitorForm {

    public MonitorForm(){}

    public MonitorForm(int userID, int projectID,int operatorID){
        setUserID(userID);
        setProjectID(projectID);
        String operation = Operation.toString(Operation.getOperation(operatorID));
        setOperation(operation);
        setOperateTime(operateTime);
    }

    private int monitorID;
    private int userID;
    private int projectID;
    private String operation;
    private Time operateTime;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getMonitorID() {
        return monitorID;
    }

    public void setMonitorID(int monitorID) {
        this.monitorID = monitorID;
    }

    public Time getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Time operateTime) {
        this.operateTime = operateTime;
    }

}
