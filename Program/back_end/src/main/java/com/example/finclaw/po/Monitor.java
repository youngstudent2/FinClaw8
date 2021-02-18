package com.example.finclaw.po;

import com.example.finclaw.enums.Operation;
import java.sql.Timestamp;
import java.util.Objects;

public class Monitor {

    private int monitorID;

    private int userID;

    private int projectID;

    private String operation;

    private Timestamp operateTime;


    public Monitor(){}

    public Monitor(int userID, int projectID, int operatorID){
        setUserID(userID);
        setProjectID(projectID);
        String operation = Operation.toString(Objects.requireNonNull(Operation.getOperation(operatorID)));
        setOperation(operation);
        setOperateTime(operateTime);
    }

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

    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

}
