package com.example.finclaw.vo.CitiAPI;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
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
     * 通行令牌，通过调用接口获得，组成 Authorization
     */
    private String access_token = "";


    /**
     * 获取token时的返回类型
     */
    private final String response_type = "code";


    /**
     * 从实例中获取，为固定值，表示范围
     */
    private final String scope = "pay_with_points";

    /**
     * 表示业务范围
     * 消费者银行业务
     */
    private final String businessCode = "GCB";


    /**
     * 代表地区，但香港API调用时也是 en_US ，可能是代表服务器所在地
     */
    private final String locale = "en_US";

    /**
     * 这个系统用的是香港的API，所以地区代码为 hk
     */
    private final String countryCode = "hk";

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
    private static String Authorization = "";


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
     * 在应用程序注册后生成的客户端ID
     * 当前使用的是已经成功注册了的finclaw客户端id
     */
    private final String client_id = "91546c2c-701d-48da-baff-3637a217afb9";


    /**
     * 在应用程序注册后生成的客户端密钥
     * finclaw客户端密钥
     */
    private final String client_se = "D7eQ4wX1mE0cU2qG2dI5eF7eE8tC0aN6dA2kG7uC7dB8gX6qJ3";


    /**
     * 账户的用户名
     */
    private final String UserName = "hanxi123";


    /**
     * 账账户的密码
     */
    private final String PassWord = "20000508hx";


    /**
     * 没有服务器的情况下借用了360的浏览界面
     */
    private final String redirect_uri = "https://hao.360.com";


    /**
     * 请求体中的详细内容
     */
    private String Content = "";

    /**
     * 请求头中传输的数据，用于鉴权时传输上一步中获得的response数据
     */
    private String data = "";

    /**
     * 请求头中的字段，目前遇到的调用中均为空
     */
    private String clientdetails = "";


    /**
     * Unique ID created for an Application
     * 在提交贷款申请后取得的标识码
     */
    private String applicationId = "";


    /**
     * 在部分API中用作参数，但官网没有给出示例参数
     * 可能需要在注册app后才能获得
     */
    private String btSupportedAccountGroup = "READY_CREDIT";


    /**
     * Base64编码与解码工具
     *
     */
    final Base64.Encoder encoder = Base64.getEncoder();
    final Base64.Decoder decoder = Base64.getDecoder();




    /**
     * 采用自有账户调用API时需要用这个方式进行创建
     * 由于我们的账户确定，直接在这里写死
     */
    public CitiRequestBody(String api){

        String auth = client_id + ":" + client_se;

        byte[] authByte = auth.getBytes(StandardCharsets.UTF_8);

        //对auth使用Base进行编码
        String auth_base = encoder.encodeToString(authByte);

        //编码前面要加上"Basic "，注意有空格！
        String Authorization = "Basic "+auth_base.replaceAll("[\\s*\t\n\r]", "");

        setAuthorization(Authorization);

        setApi(api);
    }

    /**
     * 默认的空方法
     * 只设置初始的Authorization
     */
    public CitiRequestBody(){

        String auth = client_id + ":" + client_se;

        byte[] authByte = auth.getBytes(StandardCharsets.UTF_8);

        //对auth使用Base进行编码
        String auth_base = encoder.encodeToString(authByte);

        //编码前面要加上"Basic "，注意有空格！
        String Authorization = "Basic "+auth_base.replaceAll("[\\s*\t\n\r]", "");

        setAuthorization(Authorization);
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

    public String getClientdetails() {
        return clientdetails;
    }

    public void setClientdetails(String clientdetails) {
        this.clientdetails = clientdetails;
    }

    public String getBtSupportedAccountGroup() {
        return btSupportedAccountGroup;
    }

    public void setBtSupportedAccountGroup(String btSupportedAccountGroup) {
        this.btSupportedAccountGroup = btSupportedAccountGroup;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getResponse_type() {
        return response_type;
    }

    public String getScope() {
        return scope;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocale() {
        return locale;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getClient_se() {
        return client_se;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }
}
