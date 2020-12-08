package com.hunau.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wking
 * @create 2020-12-04 21:02
 */
public class httpClientDoGet {
    public String DoPostParam() throws IOException {
        String appkey="EY7zobGomIvkpPWWhuAiDOoR6T59uBEh";
        String appsecret="JLhrYqM4ekxsj2uXfQuoY9gDiz4km4RP";
        String encode = AppKeytoBase64.encode(appkey, appsecret);
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求，访问bimface
        HttpPost httpPost = new HttpPost("https://api.bimface.com/oauth2/token");

        // ，设置post请求参数
        List<NameValuePair> parameters = new ArrayList();
        parameters.add(new BasicNameValuePair("Authorization", "Basic"+" "+encode));
        parameters.add(new BasicNameValuePair("Content-Type", "application/json"));
        System.out.println(encode);
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);
        httpPost.addHeader("Authorization", "Basic"+" "+encode);
        httpPost.addHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应体
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
                return content;
            }
        } finally {
            if (response != null) {
                response.close();
            }
            // 关闭浏览器
            httpclient.close();
        }
    return null;
    }
    public String doGetParamOfModelToken(String actoken,String fileid) throws URISyntaxException, IOException {


        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建URI对象，并且设置请求参数
        URI uri = new URIBuilder("https://api.bimface.com/view/token").setParameter("fileId",fileid).build();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("Authorization","Bearer "+actoken);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
                return content;
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
        return null;
    }

public String doPostParamOfChildFileToken(String accessToken,String fileid,String integrateId) throws URISyntaxException, IOException {
    // 创建Httpclient对象
    CloseableHttpClient httpclient = HttpClients.createDefault();
    // 创建http POST请求，访问bimface
    HttpPost httpPost = new HttpPost("https://api.bimface.com/data/v2/integrations/{integrateId}/files/{fileId}/viewToken");

    // ，设置post请求参数
    List<NameValuePair> parameters = new ArrayList();
    parameters.add(new BasicNameValuePair("fileId", fileid));
    parameters.add(new BasicNameValuePair("integrateId", integrateId));

    // 构造一个form表单式的实体
    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
    // 将请求实体设置到httpPost对象中
    httpPost.setEntity(formEntity);
    httpPost.addHeader("Authorization", "Bearer "+accessToken);
    CloseableHttpResponse response = null;
    try {
        // 执行请求
        response = httpclient.execute(httpPost);
        // 判断返回状态是否为200
        if (response.getStatusLine().getStatusCode() == 200) {
            // 解析响应体
            String content = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(content);
            return content;
        }
    } finally {
        if (response != null) {
            response.close();
        }
        // 关闭浏览器
        httpclient.close();
    }
    return null;
}

}

