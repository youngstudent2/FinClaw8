package com.example.finclaw.enums;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
public enum ProjectStatus {
    //Running表示项目还没有截至报名
    Running("1"),
    Stop("2"),
    Training("3"),
    Finished("4"),
    Failed("5");
    private final String value;

    ProjectStatus(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
