package com.example.finclaw.vo.loan;

//小微企业  借贷表

public class LoanApplicationForm {
    private Integer userID;

    //预期借款额
    private double amount;

    //贷款人联系电话
    private String phoneNumber;

    //社会统一认证代码
    private String certificationCode;

    //注册号
    private String registrationCode;
    private String companyName;

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
}
