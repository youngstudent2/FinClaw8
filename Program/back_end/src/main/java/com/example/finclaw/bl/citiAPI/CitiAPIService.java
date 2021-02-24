package com.example.finclaw.bl.citiAPI;

import com.example.finclaw.vo.CitiAPI.CitiRequestBody;
import com.google.errorprone.annotations.CompileTimeConstant;
import okhttp3.Response;

import java.io.IOException;

public interface CitiAPIService {

    /**
     * 调用花旗接口，进行鉴权并得到 access_token
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @param code 鉴权时返回的验证码
     * @return
     */
    Response authorize(CitiRequestBody citiRequestBody, String code) throws IOException;


    /**
     * 使用申请人的详细信息创建无抵押信用申请。然后，
     * API将返回一个应用程序ID，该ID可用于对申请执行操作并检查状态
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @return
     */
    Response createApplication(CitiRequestBody citiRequestBody) throws IOException;


    /**
     * 更新已创建的贷款申请
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @param applicationId
     * @return
     */
    Response updateApplication(CitiRequestBody citiRequestBody, String applicationId);


    /**
     * 将指定的申请提交给主系统
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @param applicationId
     * @return
     */
    Response submission(CitiRequestBody citiRequestBody, String applicationId);


    /**
     * 返回已提交的申请的状态
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @return
     */
    Response status(CitiRequestBody citiRequestBody);


    /**
     * 查询申请在某个阶段的详细信息
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @return
     */
    Response stage(CitiRequestBody citiRequestBody);


    /**
     * 用于根据客户选择的计划来预订贷款。成功预订贷款后，会将参考号发送给客户
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @return
     */
    Response bookings(CitiRequestBody citiRequestBody);


    /**
     * 检查余额转账的资格
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @return
     */
    Response balanceTransfers(CitiRequestBody citiRequestBody);


    /**
     * 确认预订贷款
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @return
     */
    Response confirmation(CitiRequestBody citiRequestBody);


    /**
     * 列出了客户可以用于偿还信用卡贷款的贷款预订计划。
     * 提供适用的利率、期限、分期付款金额、费用等
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @return
     */
    Response paymentsPlans(CitiRequestBody citiRequestBody, String accountId, double loanAmount);


    /**
     * 客户查看分期付款细节
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @param accountId  The account identifier in encrypted format.
     * @param loanAmount  借款金额
     * @param tenor  合约期
     * @return
     */
    Response repaymentSchedules(CitiRequestBody citiRequestBody, String accountId, double loanAmount, Integer tenor);


    /**
     * 通过发送贷款参考id检索LOP/EPP贷款的剩余偿还计划列表。
     * LOP
     * EPP即Easy Payment Plans。一种信用卡分期贷款策略
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @return
     */
    Response repaymentSchedulesList(CitiRequestBody citiRequestBody, String loanReferenceId);


    /**
     * 获取贷款的还款时间表详细信息，包括无抵押贷款的现款额度，贷款金额，期限，利率，费用等
     * loanAmount,insurancePremiumAmount,feeAmount,loanInterestRate均为double格式的String类型变量
     * tenor为Integer类型变量
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @param loanAmount  借款金额
     * @param insurancePremiumAmount
     * @param feeAmount
     * @param loanInterestRate
     * @param tenor  合约期
     * @return
     */
    Response repaymentScheduleDetails(CitiRequestBody citiRequestBody, double loanAmount, double insurancePremiumAmount, double feeAmount, double loanInterestRate, Integer tenor);


    /**
     * 选择贷款计划并完成预登录贷款预订后，将触发此API。
     * 返回贷款参考号和还款方式
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @param offerId  his Refers to the unique id for the Pre login offer
     * @return
     */
    Response bookingsPlan(CitiRequestBody citiRequestBody, String offerId);


    /**
     * 用于获取客户信用卡上已登记贷款的列表
     * @param citiRequestBody  请求体，包含了此次调用的详细信息
     * @param offerId  This Refers to the unique id for the Pre login offer.
     * @param offerType  This is a reference data field. Please use /v1/utilities/referenceData/{offerType} resource to get valid value of this field with description
     * @param offerIndicator  This is a reference data field. Please use /v1/utilities/referenceData/{offerType} resource to get valid value of this field with description
     * @return
     */
    Response loans(CitiRequestBody citiRequestBody, String offerId, String offerType, String offerIndicator);
}
