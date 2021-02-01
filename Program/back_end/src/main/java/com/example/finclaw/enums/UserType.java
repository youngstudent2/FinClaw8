package com.example.finclaw.enums;


public enum UserType {
    Manager("1"),
    DataManager("2"),
    Cooperation("3");
    private final String value;

    UserType(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
