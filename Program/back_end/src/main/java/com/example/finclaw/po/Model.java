package com.example.finclaw.po;

/**
 * @Author: GLH
 * @Date:   2020-10-12
 */
public class Model {
    private Integer modelID;
    private String mid;
    private String modelVerion;//和mid一起标识当前版本模型
    private String modelName;//在load_bind时需要指明，predict时是使用mname来进行标识
    private String jid;//query时使用

    public Model(){}

    public Model(String mid, String modelVerion, String modelName, String jid){
        this.mid = mid;
        this.modelVerion = modelVerion;
        this.modelName = modelName;
        this.jid = jid;
    }

    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getModelVerion() {
        return modelVerion;
    }

    public void setModelVerion(String modelVerion) {
        this.modelVerion = modelVerion;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }
}
