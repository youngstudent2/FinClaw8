package com.example.finclaw.vo.loan;

import java.sql.Timestamp;

public class LoanApplicationVO {

    private Integer loanApplicationID;

    private Integer userID;

    private String userName;

    /**
     * 预期借款额
     */
    private double amount;

    /**
     * 贷款人联系电话
     */
    private String phoneNumber;

    /**
     * 社会统一认证代码
     */
    private String certificationCode;

    /**
     * 注册号
     */
    private String registrationCode;

    private String companyName;

    /**
     * 借款人完成借款时置为true
     */
    private boolean hasDealt;

    private Timestamp createTime;


    public Integer getLoanApplicationID() {
        return loanApplicationID;
    }

    public void setLoanApplicationID(Integer loanApplicationID) {
        this.loanApplicationID = loanApplicationID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCertificationCode() {
        return certificationCode;
    }

    public void setCertificationCode(String certificationCode) {
        this.certificationCode = certificationCode;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isHasDealt() {
        return hasDealt;
    }

    public void setHasDealt(boolean hasDealt) {
        this.hasDealt = hasDealt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
