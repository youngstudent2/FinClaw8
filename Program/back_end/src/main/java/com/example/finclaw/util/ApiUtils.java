package com.example.finclaw.util;

import com.alibaba.fastjson.JSONObject;
import com.example.finclaw.vo.CitiAPI.CitiRequestBody;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;


/**
 * 提供调用第三方API 的 get与 post 接口
 */

@Slf4j
public class ApiUtils {
    /**
     * 表单格式传输
     */
    private static final String FORM_CONTEXT_TYPE ="application/x-www-form-urlencoded";

    /**
     * json 默认的编码类型
     */
    private static final  String JSON_CONTENT_TYPE = "application/json";

    /**
     * 默认的编码格式
     */
    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 请求配置对象
     */
    private static RequestConfig requestConfig;

    /**
     * 当调用出现错误时，打印调用信息
     */
    private static Logger log;


    /**
     *  get 请求，将参数包含在 url 路径中
     *  url : 路径
     *  return: json 对象
     */
    public static JSONObject doGet(String url){
        JSONObject jsonObject = null;
        try(CloseableHttpClient client = HttpClients.createDefault();){
            HttpGet request  = new HttpGet(url);
            request.setConfig(requestConfig);
            try(CloseableHttpResponse response = client.execute(request);){
                int statusCode = response.getStatusLine().getStatusCode();
                if(statusCode == HttpStatus.SC_OK){
                    HttpEntity entity = response.getEntity();
                    String responseContent = EntityUtils.toString(entity);
                    jsonObject = JSONObject.parseObject(responseContent);
                }else{
                    log.info("Get请求失败：{},状态码：{}  \nurl: "+url+"\nstatusCode: "+statusCode);
                }
            }
        }catch (IOException e){
            log.info("Get 请求异常：{}，状态码：{}  \nurl: "+url+"\ne.getMessage: "+e.getMessage());
            e.printStackTrace();
        }
        return  jsonObject;
    }


    /**
     * get 请求，将参数以Map 的形式传入
     * path : 包括 协议、主机、端口、资源路径
     * param: 请求参数
     *
     * @param
     */
    public static JSONObject doGet(String path,Map<String,String> params){
        List<NameValuePair> queryParans = convertParamsMapToList(params);
        URI uri = null;
        try{
            uri = new URIBuilder()
                    .setPath(path)
                    .setParameters(queryParans)
                    .build();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return doGet(Objects.requireNonNull(uri).toString());
    }


    /**
     *  将Map<String,String> 类型的请求参数转换为 List<NameValuePair>
     * @param
     *
     */
    private static List<NameValuePair> convertParamsMapToList(Map<String,String> params){
        List<NameValuePair> queryParams  = new ArrayList<>();
        for(String s : params.keySet()){
            queryParams.add(new BasicNameValuePair(s,params.get(s)));
        }
        return  queryParams;
    }

    /**
     * 将请求拆分开传入
     *
     * scheme 请求协议
     * host  主机地址
     * port 端口
     * path 路径
     * params 请求参数
     * @param
     */
    public static JSONObject doGet(String scheme,String host,Integer port,String path,Map<String,String> params){
        List<NameValuePair> queryParams = convertParamsMapToList(params);
        URI uri = null;
        try {
            uri = new URIBuilder().setScheme(scheme)
                    .setHost(host)
                    .setPort(port)
                    .setPath(path)
                    .setParameters(queryParams)
                    .build();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return  doGet(uri.toString());
    }


    /**
     *  post 请求，请求参数被封装在 JSONObject
     *  url ： 请求地址
     *  jsonParam :请求参数
     *
     */
    public static JSONObject doPost(String url,JSONObject jsonParam){
        return doPost(url,jsonParam,null);
    }

    /**
     * doPost ，以表单提交
     */
    public static JSONObject doPost(String url,String params){
        return  doPost(url,params,FORM_CONTEXT_TYPE,null);
    }

    /**
     * post 请求，请求参数被封装在 JSONObject 中，可以设置字符编码
     * url: 请求地址
     * jsonParam : 请求参数
     * charset 字符编码方法
     */
    public static JSONObject doPost(String url,JSONObject jsonParam,String charset){
        return  doPost(url,jsonParam.toJSONString(),JSON_CONTENT_TYPE,charset);
    }



    public static JSONObject doPost(String url,JSONObject jsonParam,boolean isJsonParam,String charset){
        return  doPost(url,jsonParam.toJSONString(),JSON_CONTENT_TYPE,charset);
    }


    /**
     * post 请求，参数为字符串，可以为 JSON ,可以为普通格式，可以设置字符编码
     * 如果为 json 格式， isJsonStringParam = true
     * 如果是普通格式: name  =Jack&age =10 ,则 isJsonStringParam = false
     *
     * url : 请求地址
     * stringParam 请求参数字符串
     * isJsonStringParam : 请求是否为 json 格式
     * charset 字符编码格式
     */
    public static JSONObject doPost(String url,String stringParam,boolean isJsonStringParam,String charset){
        JSONObject jsonResult = null;
        if(isJsonStringParam){
            jsonResult = doPost(url,stringParam,JSON_CONTENT_TYPE,charset);
        }else{
            jsonResult = doPost(url,stringParam,FORM_CONTEXT_TYPE,charset);
        }
        return jsonResult;
    }

    /**
     * Post 请求
     * url: 请求地址
     * requestParam 请求参数，字符串格式
     * contentType 内容编码格式
     * charset 字符编码格式
     *
     */
    public static JSONObject doPost(String url,String requestParam,String contentType,String charset){
        charset = charset==null?DEFAULT_CHARSET:charset;
        JSONObject jsonResult = null;
        try(CloseableHttpClient httpClient = HttpClients.createDefault();){
            HttpPost httpPost = new HttpPost(url);
            //构造实体请求
            StringEntity requestEntity = new StringEntity(requestParam,charset);
            requestEntity.setContentEncoding(charset);
            requestEntity.setContentType(contentType);
            httpPost.setEntity(requestEntity);
            httpPost.setConfig(requestConfig);
            try(CloseableHttpResponse response = httpClient.execute(httpPost);){
                int statusCode = response.getStatusLine().getStatusCode();
                if(statusCode  == HttpStatus.SC_OK){
                    HttpEntity responseEntity  = response.getEntity();
                    String responseContent = EntityUtils.toString(responseEntity,charset);
                    jsonResult = JSONObject.parseObject(responseContent);
                }else{
                    log.info("post 请求失败:{},状态码：{}  \nurl: "+url+"\nstatusCode: "+statusCode);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonResult;
    }


    /**
     * 调用花旗接口的方法,需要把Request请求头作为参数
     * 本来想使用一种统一的POST方法进行集成调用，后来发现不可行
     * 目前这个方法可以适用绝大多数花旗API中的POST请求，具体使用还需要查看文档中对参数的要求
     * 不管怎么说，还是起到了化简代码的作用
     * @param citiRequestBody
     * @return
     * @throws IOException
     */
    public static Response Post(CitiRequestBody citiRequestBody) throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, citiRequestBody.getContent());

        Request request = new Request.Builder()
                .url(citiRequestBody.getUrl())
                .post(body)
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("content-type", citiRequestBody.getContent_Type())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        return client.newCall(request).execute();
    }


    /**
     * 调用花旗接口的方法,需要把Request请求头作为参数
     * 这个方法中可以设置 accept-language，默认设置为 en-us
     * @param citiRequestBody
     * @return
     * @throws IOException
     */
    public static Response Post_en(CitiRequestBody citiRequestBody) throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, citiRequestBody.getContent());

        Request request = new Request.Builder()
                .url(citiRequestBody.getUrl())
                .post(body)
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("accept-language", citiRequestBody.getAccept_Language())
                .addHeader("content-type", citiRequestBody.getContent_Type())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        return client.newCall(request).execute();
    }

    public static Response Post_detil(CitiRequestBody citiRequestBody) throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, citiRequestBody.getContent());

        Request request = new Request.Builder()
                .url(citiRequestBody.getUrl())
                .post(body)
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("clientdetails", citiRequestBody.getClientdetails())
                .addHeader("accept-language", citiRequestBody.getAccept_Language())
                .addHeader("content-type", citiRequestBody.getContent_Type())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        return client.newCall(request).execute();
    }

    /**
     *调用花旗API的GET请求所用方法，具体使用时还需要阅读文档
     * @param citiRequestBody
     * @return
     * @throws IOException
     */
    public static Response GET(CitiRequestBody citiRequestBody) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(citiRequestBody.getUrl())
                .get()
                .addHeader("authorization", citiRequestBody.getAuthorization())
                .addHeader("uuid", citiRequestBody.getUuid())
                .addHeader("client_id", citiRequestBody.getClient_id())
                .addHeader("accept", citiRequestBody.getAccept())
                .build();

        return client.newCall(request).execute();
    }

}
