package com.example.finclaw.vo.model;

import com.example.finclaw.po.Model;

public class ModelVO {
    private Integer modelID;
    private String name;

    public ModelVO(Model model) {
        this.modelID = model.getModelID();
        this.name = model.getName();
    }

    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
