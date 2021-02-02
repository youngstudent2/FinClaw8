package com.example.finclaw.enums;


public enum UserType {
    Bank("1"),
    Company("2"),//小微企业
    DataProvider("3"),
    Admin("4"),//平台管理员
    Unauthorized("5");//未认证用户
    private final String value;

    UserType(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
