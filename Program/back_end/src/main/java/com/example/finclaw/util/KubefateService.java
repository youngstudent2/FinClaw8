package com.example.finclaw.util;

import java.util.ArrayList;

public interface KubefateService {
    /**
     *
     * @param userID ID数组，ID为系统为参与训练任务的各方指定的全局唯一id,默认给出第一个id为监管方的id
     * @param password 各方（参与方和监管方）主机上用户的密码，默认给出的第一个密码为监管方主机上的用户
     * @param ip 参与训练任务的各方主机的ipv4地址,默认给出的第一个ip为监管方的ip
     * @param filepath 参与训练任务的各方主机上的数据集路径（绝对路径）, 默认给出的第一个dataPath为监管方主机上的数据集路径
     * @param projectName 项目名称
     */
    public boolean deploy(String[] userID, String[] password, String[] ip, String[] filepath, String projectName);

    /**
     *
     * @param algorithm 选用的算法，目前填SecureBoost就好
     * @param projectName 项目名称
     */
    public boolean submit(String algorithm, String projectName);

    public boolean delete();

    public boolean bind(String modelID, String modelVersion,String modelName);

    public double predict(String modelName, String[] args);
}
