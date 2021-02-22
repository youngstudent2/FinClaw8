package com.example.finclaw.blImpl.citiAPI;


import com.example.finclaw.bl.citiAPI.CitiAPIService;
import com.example.finclaw.util.ApiUtils;
import com.example.finclaw.vo.CitiAPI.CitiRequestBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CitiAPIServiceImpl implements CitiAPIService {
    /**
     * 使用申请人的详细信息创建无抵押信用申请。然后，
     * API将返回一个应用程序ID，该ID可用于对申请执行操作并检查状态
     *
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response createApplication(CitiRequestBody citiRequestBody){

        citiRequestBody.setContent("{\"product\":{},\"applicant\":{\"motherMaidenName\":\"Lisa\",\"address\":{\"addressType\":\"HOME_ADDRESS\",\"addressLine1\":\"40A Orchard Road\",\"addressLine2\":\"#99-99 Macdonald House\",\"addressLine3\":\"Orchard Avenue 2\",\"addressLine4\":\"Street 65\",\"cityName\":\"Singapore\",\"state\":\"Singapore\",\"postalCode\":\"345346\",\"provinceCode\":\"Singapore\",\"countryCode\":\"SG\",\"okToMail\":true,\"residenceDurationInYears\":5,\"residenceDurationInMonths\":4},\"email\":{\"emailAddress\":\"matt.hayden@gmail.com\",\"okToEmail\":true,\"isPreferredEmailAddress\":true},\"phone\":{\"phoneType\":\"PRIMARY_MOBILE_NUMBER\",\"phoneCountryCode\":\"61\",\"areaCode\":\"02\",\"phoneNumber\":\"64042321\",\"extension\":\"23\",\"okToSms\":true,\"okToCall\":true},\"employmentDetails\":{\"employerName\":\"Citi Bank\",\"jobTitle\":\"ACCOUNTANT\",\"occupationCode\":\"ACCOUNTANT\",\"industryCode\":\"CITIBANK_SUB_NON_BANK\",\"employmentDurationInYears\":5,\"employmentDurationInMonths\":3,\"employmentStatus\":\"EMPLOYED\",\"monthsInPreviousEmployment\":5,\"yearsInPreviousEmployment\":4,\"accountantName\":\"Javier\",\"accountantFirmName\":\"ACME\",\"yearsInIndustry\":5,\"monthsInIndustry\":6},\"identificationDocumentDetails\":{\"idType\":\"PASSPORT\",\"idNumber\":\"S42258011\",\"idExpiryDate\":\"2027-04-11\",\"idIssueDate\":\"2017-04-12\",\"idIssuePlace\":\"AU\",\"idIssueState\":\"QUEENSLAND\",\"idIssueCountry\":\"AU\",\"isPrimaryId\":true},\"consentDetails\":{\"consentType\":\"BUREAU_PULL_CONSENT\",\"isConsentGiven\":true}}}");

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
     *
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response updateApplication(CitiRequestBody citiRequestBody){

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
     *
     * @param citiRequestBody
     * @return
     */
    @Override
    public Response submission(CitiRequestBody citiRequestBody) {

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
}
