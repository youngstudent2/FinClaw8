package com.example.finclaw.bl.citiAPI;

import com.example.finclaw.vo.CitiAPI.CitiRequestBody;
import okhttp3.Response;

import java.io.IOException;

public interface CitiAPIService {
    /**
     * 使用申请人的详细信息创建无抵押信用申请。然后，
     * API将返回一个应用程序ID，该ID可用于对申请执行操作并检查状态
     * @param citiRequestBody
     * @return
     */
    Response createApplication(CitiRequestBody citiRequestBody) throws IOException;


    /**
     * 更新已创建的贷款申请
     * @param citiRequestBody
     * @return
     */
    Response updateApplication(CitiRequestBody citiRequestBody);


    /**
     * 将指定的申请提交给主系统
     * @param citiRequestBody
     * @return
     */
    Response submission(CitiRequestBody citiRequestBody);


    /**
     * 返回已提交的申请的状态
     * @param citiRequestBody
     * @return
     */
    Response status(CitiRequestBody citiRequestBody);


    /**
     * 查询申请在某个阶段的详细信息
     * @param citiRequestBody
     * @return
     */
    Response stage(CitiRequestBody citiRequestBody);


}
