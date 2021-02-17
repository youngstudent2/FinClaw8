package com.example.finclaw.vo.lending;

public class LendingHistoryVO {

    private Integer lendingHistoryID;

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

    private String phoneNumber;

    /**
     * 借款人完成借款时置为true
     */
    private boolean hasDealt;


    public Integer getLendingHistoryID() {
        return lendingHistoryID;
    }

    public void setLendingHistoryID(Integer lendingHistoryID) {
        this.lendingHistoryID = lendingHistoryID;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isHasDealt() {
        return hasDealt;
    }

    public void setHasDealt(boolean hasDealt) {
        this.hasDealt = hasDealt;
    }

    public String getLenderName() {
        return lenderName;
    }

    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }
}
