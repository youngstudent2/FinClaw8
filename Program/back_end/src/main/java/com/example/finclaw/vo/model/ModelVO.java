package com.example.finclaw.vo.model;

import com.example.finclaw.po.Model;

public class ModelVO {
    private Integer modelID;
    private String modelName;

    public ModelVO(Model model) {
        this.modelID = model.getModelID();
        this.modelName = model.getModelName();
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
}
