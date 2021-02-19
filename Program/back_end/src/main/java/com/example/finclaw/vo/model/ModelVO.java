package com.example.finclaw.vo.model;

import com.example.finclaw.po.Model;

public class ModelVO {
    private Integer modelID;
    private String mid;
    private String modelVersion;
    private String modelName;
    private String jid;

    public ModelVO(){}

    public ModelVO(Model model) {
        this.modelID = model.getModelID();
        this.mid = model.getMid();
        this.modelVersion = model.getModelVerion();
        this.modelName = model.getModelName();
        this.jid = model.getJid();
    }

    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }
}
