package com.example.finclaw.vo.CitiAPI;

import java.util.UUID;

public class CitiRequestBody {

    /**
     * 花旗API的URL根目录
     * 当前请求中调用的API的实际URL
     * 由类内部进行自动生成，用get方法获取
     * 这里的URL仅用于使用OKHttp调用   还有另一种调用实现，见 /Util/ApiUtils
     */
    private final String URL = "https://sandbox.apihub.citi.com/gcb/api";


    /**
     * 当前请求中调用的API
     * 在设定时只需要调用set方法，将API名作为参数
     * 示例参数：/authCode/oauth2/token/us/gcb ，调用的是 POST /authCode/oauth2/token/us/gcb 接口
     */
    private String api = "";


    /**
     * 请求内容的解析类型,固定为 application/json
     */
    private final String Content_Type = "application/json";


    /**
     * 返回内容的解析类型，固定为 application/json
     */
    private final String Response_Type = "application/json";


    /**
     * 接受的语言标准
     * 这里选择的是英语
     */
    private final String Accept_Language = "en-us";


    /**
     * 鉴权码（加密），具体规则为：Authorization = "Base64 "+(client_id:client_se)的Base64编码
     *
     * 注：
     * 1.前面的"Base64 "有一个空格
     * 2.根据RFC822规定，BASE64Encoder编码每76个字符，还需要加上一个回车换行
     * 3.
     */
    private String Authorization = "";


    /**
     * 账号的uuid，通用唯一识别码（Universally Unique Identifier）
     * uuid的生成与当前时间有关，get方法中可以自动生成当前的uuid
     */
    private String uuid = "";


    /**
     * 服务器返回内容的解析类型，固定为 application/json
     */
    private final String Accept = "application/json";


    /**
     * 在应用程序注册期间生成的客户端ID
     */
    private String client_id = "";


    /**
     * 官方demo账户的用户名
     */
    private final String UserName = "SandboxUser1";


    /**
     * 官方demo账账户的密码
     */
    private final String PassWord = "P@ssUser1$";

    /**
     * 请求体中的详细内容
     */
    private String Content = "";


    /**
     * Unique ID created for an Application
     * 暂时没有的情况下，用了官网的一个
     */
    private String applicationId = "647W7T959648";


    /**
     * 请求头中的示例数据(Header Parameters)
     * 由花旗官方给出，用于测试API
     * 程序运行及测试使用这个
     */
    public CitiRequestBody(String api){
        setAuthorization("Bearer AAIkMzkwNmRkNmQtNTM0Yi00ZDIwLTgxZDctMGU3ODg0ODAxM2Ezi37ikQsudh6mwKM07kMPiKZ0EHQLF1bEtzOl-vGGFJ31uYI0fO8BAO8GBU7qNaQjur9OrirxPXJ8pCFTe9-EfsvkNTbnYJBtQ0VK61SqZkIcigELu1N7El67l5yrZt1mL96cw-DkGEhEKjjQ4NAL-NF7IDMRC-F6HM8Pyb2yTrWwi9WwDxse7f94cPs9EPM0o4izTyjfDMDrqAWpvZ7o7z_jPjAURw1oHy3gFQKQKgE");
        setClient_id("3906dd6d-534b-4d20-81d7-0e78848013a3");
        setApi(api);
    }


    /**
     * 采用自有账户调用API时需要用这个方式进行创建
     *
     * @param Authorization
     * @param client_id
     */
    public CitiRequestBody(String api, String Authorization, String client_id){
        setAuthorization(Authorization);
        setClient_id(client_id);
        setApi(api);
    }

    /**
     * 默认的空方法
     */
    public CitiRequestBody(){
    }

    public String getContent_Type() {
        return Content_Type;
    }

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }

    public String getUuid() {
        return UUID.randomUUID().toString();    //.replace("-", "").toLowerCase();
    }

    public String getAccept() {
        return Accept;
    }


    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getUrl() {
        return URL + api;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getResponse_Type() {
        return Response_Type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getAccept_Language() {
        return Accept_Language;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
