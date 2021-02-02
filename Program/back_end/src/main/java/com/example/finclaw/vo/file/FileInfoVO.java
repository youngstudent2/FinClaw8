package com.example.finclaw.vo.file;

import java.sql.Timestamp;

public class FileInfoVO {
    private Integer fileID;
    private Integer projectID;
    private Integer operatorID;
    private Integer trainedTimes;
    private String fileName;
    private String filePath;
    private Timestamp uploadTime;

    public FileInfoVO() {
    }

    public FileInfoVO(int projectID, int operatorID, String fileName) {
        this.projectID = projectID;
        this.operatorID = operatorID;
        this.fileName = fileName;
    }


    public Integer getFileID() {
        return fileID;
    }

    public void setFileID(Integer fileID) {
        this.fileID = fileID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public Integer getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(Integer operatorID) {
        this.operatorID = operatorID;
    }

    public Integer getTrainedTimes() {
        return trainedTimes;
    }

    public void setTrainedTimes(Integer trainedTimes) {
        this.trainedTimes = trainedTimes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
