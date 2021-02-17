package com.example.finclaw.enums;


public enum UserType {
    Bank("1"),
    Company("2"),//小微企业
    DataProvider("3"),
    Admin("4"),//平台管理员
    UnauthorizedBank("5"),//未认证
    UnauthorizedCompany("6"),
    UnauthorizedDataProvider("7"),
    Rejected("8");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
