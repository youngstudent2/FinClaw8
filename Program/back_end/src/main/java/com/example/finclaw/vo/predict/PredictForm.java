package com.example.finclaw.vo.predict;

public class PredictForm {
    private Integer projectID;
    private String[] featureVector;

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String[] getFeatureVector() {
        return featureVector;
    }

    public void setFeatureVector(String[] featureVector) {
        this.featureVector = featureVector;
    }
}
