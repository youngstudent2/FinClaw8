package com.example.finclaw.vo.attendance;

public class AttendanceVO {              //记录一条项目参与记录
    private Integer userID;//因为现在默认一个银行/数据提供方只有一个账号，就直接用userID来标识一个数据提供方了
    private Integer projectID;
    private boolean isChosen;//银行是否选择这个数据提供方的数据训练
    private boolean isReady;//数据提供方是否准备好数据

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

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
