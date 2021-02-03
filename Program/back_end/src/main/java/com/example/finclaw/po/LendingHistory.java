package com.example.finclaw.po;

public class LendingHistory {
    private Integer lendingHistoryID;
    private Integer bankID;//银行的userID
    private Integer lenderID;//贷款的小微企业的userID
    private String bankName;
    private double amount;//意愿贷款数额
    private double interestRate;//年利率
    private String phoneNumber;
    private boolean hasDealt;//借款人完成借款时置为true

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

    public boolean isHasDealt() {
        return hasDealt;
    }

    public void setHasDealt(boolean hasDealt) {
        this.hasDealt = hasDealt;
    }
}
