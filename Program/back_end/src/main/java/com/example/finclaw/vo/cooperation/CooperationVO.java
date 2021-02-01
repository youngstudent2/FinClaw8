package com.example.finclaw.vo.cooperation;

import com.example.finclaw.po.Cooperation;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class CooperationVO {
    private Integer cooperationID;
    private String cooperationName;
    private String manager;
    private String phoneNumber;
    private String ipAddress;
    private String serviceName;
    private String servicePassword;
    private Integer authority;


    public Integer getAuthority(){
        return this.authority;
    }

    public void setAuthority(Integer authority){
        this.authority = authority;
    }

    public void setCooperationID(Integer cooperationId){
        this.cooperationID = cooperationId;
    }

    public Integer getCooperationID(){
        return cooperationID;
    }

    public String getCooperationName() {
        return cooperationName;
    }

    public void setCooperationName(String cooperationName) {
        this.cooperationName = cooperationName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServicePassword() {
        return servicePassword;
    }

    public void setServicePassword(String servicePassword) {
        this.servicePassword = servicePassword;
    }
}
