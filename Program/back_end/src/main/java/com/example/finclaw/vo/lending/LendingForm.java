package com.example.finclaw.vo.lending;

public class LendingForm {

    /**
     * 银行的userID
     */
    private Integer bankID;

    private String bankName;

    /**
     * 贷款的小微企业的userID
     */
    private Integer lenderID;

    private String lenderName;

    /**
     * 意愿贷款数额
     */
    private double amount;

    /**
     * 年利率
     */
    private double interestRate;

    /**
     * 银行经理联系方式
     */
    private String phoneNumber;

    /**
     * 贷款说明
     */
    private String description;

    public Integer getBankID() {
        return bankID;
    }

    public void setBankID(Integer bankID) {
        this.bankID = bankID;
    }

    public Integer getLenderID() {
        return lenderID;
    }

    public void setLenderID(Integer lenderID) {
        this.lenderID = lenderID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLenderName() {
        return lenderName;
    }

    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }
}
