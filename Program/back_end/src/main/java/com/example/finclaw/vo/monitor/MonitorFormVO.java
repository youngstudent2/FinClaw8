package com.example.finclaw.vo.monitor;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.po.MonitorForm;
import com.example.finclaw.vo.account.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;


public class MonitorFormVO {
    private int monitorID;
    private int userID;
    private int projectID;
    private String operation;
    private Time operateTime;
    private String userName;

    @Autowired
    AccountService accountService;

    public MonitorFormVO(MonitorForm monitorForm){
        this.monitorID = monitorForm.getMonitorID();
        this.userID = monitorForm.getUserID();
        this.projectID = monitorForm.getProjectID();
        this.operation = betterOperation(monitorForm.getOperation());
        this.operateTime = monitorForm.getOperateTime();
        UserVO user = accountService.getUserInfo(userID);
        this.userName = user.getUsername();
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Time getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Time operateTime) {
        this.operateTime = operateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String betterOperation(String Operation){
        switch (operation){
            case "Add":
                return "Add: 源操作码101. 项目中新加入一名合作用户.";
            case "Delete":
                return "Delete: 源操作码102. 项目中删除了一名合作用户.";
            case "Modify":
                return "Modify: 源操作码103. 项目发生变更.";
            case "Use":
                return "Use: 源操作码104. 项目模型被调用.";
        }
        return null;
    }

    public int getMonitorID() {
        return monitorID;
    }

    public void setMonitorID(int monitorID) {
        this.monitorID = monitorID;
    }
}
