package com.example.finclaw.blImpl.citiAPI;


import com.alibaba.fastjson.JSONObject;
import com.example.finclaw.bl.citiAPI.CitiAPIService;
import com.example.finclaw.util.ApiUtils;
import com.example.finclaw.vo.CitiAPI.CitiRequestBody;
import okhttp3.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Objects;

@Service
public class CitiAPIServiceImpl implements CitiAPIService {

    /**
     * 调用花旗接口，进行鉴权并得到 access_token
     * 鉴权第一步的GET请求交由前端完成
     * 在完成后重设CitiRequestBody中的authorization（静态变量），并将其用于之后的请求
     * @param citiRequestBody
     * @param code 鉴权时返回的验证码
     * @return
     */
    @Override
    public Response authorize(CitiRequestBody citiRequestBody, String code) throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&scope=%2Fapi");

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/token/hk/gcb")
                .post(body)
                .addHeader("accept",citiRequestBody.getAccept())
                .addHeader("authorization",citiRequestBody.getAuthorization())
                .addHeader("content-type","application/x-www-form-urlencoded")
                .build();


        Response response = client.newCall(request).execute();

        //重设Authorization
        JSONObject jsonObject = JSONObject.parseObject(Objects.requireNonNull(response.body()).toString());
        citiRequestBody.setToken_type(jsonObject.getString("token_type"));
        citiRequestBody.setAccess_token(jsonObject.getString("access_token"));

        return response;

        /*
        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/authorize?response_type=code&scope=pay_with_points%20accounts_details_transactions%20customers_profiles%20payees%20personal_domestic_transfers%20internal_domestic_transfers%20external_domestic_transfers%20bill_payments%20cards%20onboarding%20reference_data%20meta_data%20insurance_purchase%20stock%20partner_customers_profiles&countryCode=hk&businessCode=gcb&locale=en_US&state=7fa6d325-4ee5-4ffa-36e8-66e5fcaaaf01&redirect_uri="+citiRequestBody.getRedirect_uri()+"%2Fapi-authorize&client_id="+citiRequestBody.getClient_id())
                .get()
                .build();

        Response response = client.newCall(request).execute();

        JSONObject jsonObject = JSONObject.parseObject(Objects.requireNonNull(response.body()).toString());


        citiRequestBody.setData("grant_type=authorization_code&redirect_uri="+citiRequestBody.getRedirect_uri()+"/api-authorize=&"+code+"&redirect_uri="+citiRequestBody.getRedirect_uri()+"%2Fapi-authorize&client_id="+citiRequestBody.getClient_id());

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, citiRequestBody.getRedirect_uri());

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/token/hk/gcb")
                .post(body)
                .addHeader("accept",citiRequestBody.getAccept())
                .addHeader("authorization",citiRequestBody.getAuthorization())
                .addHeader("content-type",citiRequestBody.getContent_Type())
                .addHeader("cross-domain","true")
                .build();

        return client.newCall(request).execute();

         */
    }

    /**
     * 使用申请人的详细信息创建无抵押信用申请。然后，
     * API将返回一个applicationID，该ID可用于对申请执行操作并检查状态，并用于后续的调用
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response createApplication(CitiRequestBody citiRequestBody){

        citiRequestBody.setApi("https://sandbox.apihub.citi.com/gcb/api/v1/apac/onboarding/products/unsecured/applications");
        citiRequestBody.setContent("{\n" +
                "  \"product\": {\n" +
                "    \"creditCardProduct\": {\n" +
                "      \"productCode\": \"VC115\",\n" +
                "      \"sourceCode\": \"CIN016\",\n" +
                "      \"organization\": \"711\",\n" +
                "      \"logo\": \"115\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"applicant\": {\n" +
                "    \"name\": {\n" +
                "      \"salutation\": \"MR\",\n" +
                "      \"givenName\": \"JAMMIE\",\n" +
                "      \"surname\": \"LOUIE\"\n" +
                "    },\n" +
                "    \"email\": [\n" +
                "      {\n" +
                "        \"emailAddress\": \"JAMMIE@gmail.com\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"phone\": [\n" +
                "      {\n" +
                "        \"phoneType\": \"PRIMARY_MOBILE_NUMBER\",\n" +
                "        \"phoneCountryCode\": \"852\",\n" +
                "        \"phoneNumber\": \"67172657\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"consentDetails\": [\n" +
                "      {\n" +
                "        \"consentType\": \"PARTNER_CONSENT\",\n" +
                "        \"isConsentGiven\": \"1\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"consentType\": \"PDP_CONSENT\",\n" +
                "        \"isConsentGiven\": \"1\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}");

        Response response = null;
        try {
            response =  ApiUtils.Post_en(citiRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * 更新已创建的贷款申请
     * @param citiRequestBody
     * @param applicationId
     * @return
     */
    @Override
    public Response updateApplication(CitiRequestBody citiRequestBody, String applicationId){

        citiRequestBody.setApi("https://sandbox.apihub.citi.com/gcb/api/v1/apac/onboarding/products/unsecured/applications/"+applicationId);
        citiRequestBody.setContent("{\"product\":{},\"applicant\":{\"phone\":{\"phoneType\":\"PRIMARY_MOBILE_NUMBER\",\"phoneCountryCode\":\"65\",\"areaCode\":\"02\",\"phoneNumber\":\"64043401\",\"extension\":\"23\",\"okToSms\":\"true\",\"okToCall\":\"true\"},\"email\":{\"emailAddress\":\"matt.hayden@gmail.com\",\"okToEmail\":\"true\",\"isPreferredEmailAddress\":\"true\"},\"address\":{\"addressType\":\"HOME_ADDRESS\",\"addressLine1\":\"40A Orchard Road\",\"addressLine2\":\"#99-99 Macdonald House\",\"addressLine3\":\"Orchard Avenue 2\",\"addressLine4\":\"Street 65\",\"cityName\":\"Singapore\",\"state\":\"Singapore\",\"postalCode\":\"238838\",\"provinceCode\":\"Singapore\",\"countryCode\":\"SG\",\"okToMail\":\"true\",\"residenceDurationInYears\":5,\"residenceDurationInMonths\":4},\"motherMaidenName\":\"Lisa\",\"employmentDetails\":{\"employerName\":\"Citi Bank\",\"jobTitle\":\"ACCOUNTANT\",\"occupationCode\":\"ACCOUNTANT\",\"industryCode\":\"CITIBANK_SUB_NON_BANK\",\"employmentDurationInYears\":5,\"employmentDurationInMonths\":3,\"employmentStatus\":\"EMPLOYED\",\"monthsInPreviousEmployment\":5,\"yearsInPreviousEmployment\":4,\"accountantName\":\"Javier\",\"accountantFirmName\":\"ACME\",\"yearsInIndustry\":5,\"monthsInIndustry\":6},\"identificationDocumentDetails\":{\"idType\":\"PASSPORT\",\"idNumber\":\"S42258011\",\"idExpiryDate\":\"2027-04-11\",\"idIssueDate\":\"2017-04-12\",\"idIssuePlace\":\"AU\",\"idIssueState\":\"QUEENSLAND\",\"idIssueCountry\":\"AU\",\"isPrimaryId\":\"true\"},\"consentDetails\":{\"consentType\":\"PDP_CONSENT\",\"isConsentGiven\":\"true\"}},\"controlFlowId\":\"6e3774334f724a2b7947663653712f52456f524c41797038516a59347a437549564a77755676376e616a733d\"}");

        Response response = null;
        try {
            response = ApiUtils.Post(citiRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  response;
    }


    /**
     * 将指定的申请提交给主系统
     * @param citiRequestBody
     * @param applicationId
     * @return
     */
    @Override
    public Response submission(CitiRequestBody citiRequestBody, String applicationId) {

        citiRequestBody.setApi("https://sandbox.apihub.citi.com/gcb/api/v1/apac/onboarding/products/unsecured/applications/"+applicationId+"/submission");
        citiRequestBody.setContent("{\"controlFlowId\":\"6e3774334f724a2b7947663653712f52456f524c41797038516a59347a437549564a77755676376e616a733d\"}");

        Response response = null;

        try {
            response = ApiUtils.Post_detil(citiRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 返回已提交的申请的状态
     * 官网中给的 controlFlowId 是不能用的，这个方法暂时没有办法调用
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response status(CitiRequestBody citiRequestBody) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/apac/onboarding/products/unsecured/applications/"+citiRequestBody.getApplicationId()+"/status?controlFlowId=bb56683b25f4df93b5269260f1d519fb107870035a98a3350011028f8ff3c06d")
                .get()
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * 查询申请在某个阶段的详细信息
     *
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response stage(CitiRequestBody citiRequestBody) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/partner/v1/apac/onboarding/products/unsecured/applications/"+citiRequestBody.getApplicationId()+"/stage")
                .get()
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    /**
     * 用于根据客户选择的计划来预订贷款。成功预订贷款后，会将参考号发送给客户
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response bookings(CitiRequestBody citiRequestBody){

        citiRequestBody.setApi("/v1/accounts/"+citiRequestBody.getUserName()+"/loans/balanceTransfers/bookings");
        citiRequestBody.setContent("{\"tenor\":6,\"balanceTransferBookings\":{\"loanAmount\":680.25,\"btDisbursementOption\":\"LOAN_PAYMENT\",\"disbursementAccountId\":\"3255613852316f2b4d4d796c344e38756339654972776f663745446e6d4c32486f455a4165374a476858343d\",\"payeeType\":\"INTERNAL\",\"bankDetails\":{\"accountNumber\":\"251212582364\",\"accountHolderName\":\"Hayden\",\"bankCode\":\"DBSSG0XXX\",\"financialInstitutionCode\":\"12345\",\"billerCode\":\"11000125\"}}}");

        Response response = null;

        try {
            response = ApiUtils.Post_detil(citiRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * 检查余额转账的资格
     *
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response balanceTransfers(CitiRequestBody citiRequestBody) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/accounts/loans/balanceTransfers?btSupportedAccountGroup="+citiRequestBody.getBtSupportedAccountGroup())
                .get()
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("clientdetails", citiRequestBody.getClientdetails())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 确认预订贷款
     *
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response confirmation(CitiRequestBody citiRequestBody) {

        citiRequestBody.setContent("{\"controlFlowId\":\"6e3774334f724a2b7947663653712f52456f524c41797038516a59347a437549564a77755676376e616a733d\"}");
        citiRequestBody.setApi("/v1/accounts/loans/bookings/confirmation");

        Response response = null;

        try {
            response = ApiUtils.Post_detil(citiRequestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * 列出了客户可以用于偿还信用卡贷款的贷款预订计划。
     * 提供适用的利率、期限、分期付款金额、费用等
     * 借款金额需要为double格式
     * @param citiRequestBody
     * @param accountId
     * @param loanAmount
     * @return
     */
    @Override
    public Response paymentsPlans(CitiRequestBody citiRequestBody, String accountId, double loanAmount) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/accounts/"+accountId+"/loans/"+loanAmount+"/paymentsPlans?tenor="+"")
                .get()
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("clientdetails", citiRequestBody.getClientdetails())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    /**
     * 客户查看分期付款细节
     * @param citiRequestBody
     * @param accountId
     * @param loanAmount
     * @param tenor
     * @return
     */
    @Override
    public Response repaymentSchedules(CitiRequestBody citiRequestBody, String accountId, double loanAmount, Integer tenor) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/accounts/"+accountId+"/loans/repaymentSchedules?loanAmount="+loanAmount+"&tenor="+tenor+"&nextStartIndex="+"")
                .get()
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("clientdetails", citiRequestBody.getClientdetails())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 通过发送贷款参考id检索LOP/EPP贷款的剩余偿还计划列表。
     * LOP即law of one price，一价定律，认为在不存在阻碍诸如运输成本和关税的情况下，以同一货币表示的商品的价格在每一个国家都是相同的。
     * EPP即Easy Payment Plans，一种信用卡分期贷款策略
     * @param citiRequestBody
     * @param loanReferenceId
     * @return
     */
    @Override
    public Response repaymentSchedulesList(CitiRequestBody citiRequestBody, String loanReferenceId) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/accounts/loans/"+loanReferenceId+"/repaymentSchedules?nextStartIndex="+"")
                .get()
                .addHeader("authorization", "REPLACE_THIS_VALUE")
                .addHeader("uuid", "REPLACE_THIS_VALUE")
                .addHeader("client_id", "REPLACE_THIS_VALUE")
                .addHeader("clientdetails", "REPLACE_THIS_VALUE")
                .addHeader("accept", "REPLACE_THIS_VALUE")
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * 获取贷款的还款时间表详细信息，包括无抵押贷款的现款额度，贷款金额，期限，利率，费用等
     * loanAmount,insurancePremiumAmount,feeAmount,loanInterestRate均为double格式的String类型变量
     * tenor为Integer类型变量
     * @param citiRequestBody
     * @param loanAmount
     * @param insurancePremiumAmount
     * @param feeAmount
     * @param loanInterestRate
     * @param tenor
     * @return
     */
    @Override
    public Response repaymentScheduleDetails(CitiRequestBody citiRequestBody, double loanAmount, double insurancePremiumAmount, double feeAmount, double loanInterestRate, Integer tenor) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/applicationProcessing/products/unsecuredLoans/topup/repaymentSchedule?loanAmount="+loanAmount+"&insurancePremiumAmount="+insurancePremiumAmount+"&feeAmount="+feeAmount+"&loanInterestRate="+loanInterestRate+"&tenor="+tenor)
                .get()
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("content-type", citiRequestBody.getContent_Type())
                .addHeader("clientdetails", citiRequestBody.getClientdetails())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * 选择贷款计划并完成预登录贷款预订后，将触发此API。
     * 返回贷款参考号和还款方式
     * @param citiRequestBody
     * @param offerId
     * @return
     */
    @Override
    public Response bookingsPlan(CitiRequestBody citiRequestBody, String offerId) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"loanAmount\":680.8,\"tenor\":6,\"disbursementOption\":\"STANDING_INSTRUCTION\",\"disbursementAccountId\":\"3255613852316f2b4d4d796c344e38756339654972776f663745446e6d4c32486f455a4165374a476858343d\",\"payeeId\":\"C$0003019202$AU$XX$01000540000001\",\"birthYear\":\"1994\",\"purposeOfLoan\":\"PERSONAL\",\"bankDetails\":{\"accountNumber\":\"251212582364\",\"accountHolderName\":\"Hayden\",\"bankCode\":\"DBSSG0XXX\",\"financialInstitutionCode\":\"12345\",\"billerCode\":\"11000125\"}}");
        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/prelogin/creditCardServices/offers/"+offerId+"/loans/bookings")
                .post(body)
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("clientdetails", citiRequestBody.getClientdetails())
                .addHeader("content-type", citiRequestBody.getContent_Type())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * 用于获取客户信用卡上已登记贷款的列表
     * @param citiRequestBody
     * @param offerId
     * @param offerType
     * @param offerIndicator
     * @return
     */
    @Override
    public Response loans(CitiRequestBody citiRequestBody, String offerId, String offerType, String offerIndicator) {

        OkHttpClient client = new OkHttpClient();

        Response response = null;

        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/preLogin/creditChargeCard/creditPlans/"+offerId+"/loans?offerType="+offerType+"&offerIndicator="+offerIndicator)
                .get()
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("clientdetails", citiRequestBody.getClientdetails())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


}
