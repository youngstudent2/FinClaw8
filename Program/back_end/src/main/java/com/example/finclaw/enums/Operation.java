package com.example.finclaw.enums;

/**
 * @Author: GLH
 * @Date:   2020-10-12
 */
public enum Operation {
    Add("1"),
    Delete("2"),
    Modify("3"),
    Use("4");
    String value;

    Operation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Operation getOperation(int operatorID){
        switch (operatorID){
            case 1:
                return Operation.Add;
            case 2:
                return Operation.Delete;
            case 3:
                return Operation.Modify;
            case 4:
                return Operation.Use;
            default:
                return null;
        }
    }

    public static String toString(Operation operation){
        switch (operation){
            case Add:
                return "Add";
            case Delete:
                return "Delete";
            case Modify:
                return "Modify";
            case Use:
                return "Use";
            default:
                return "null";
        }
    }
}
