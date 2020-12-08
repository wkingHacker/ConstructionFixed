package com.hunau.controller;


import com.bimface.sdk.BimfaceClient;
import com.hunau.bean.Token;
import com.hunau.util.JsonUtils;
import com.hunau.util.httpClientDoGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Wking
 * @create 2020-12-04 21:25
 */
@RestController
@RequestMapping("/user")
public class AccessTokenController {

    @RequestMapping("/getAccess")
    public String sendToken() throws IOException, URISyntaxException {
        httpClientDoGet ht = new httpClientDoGet();
        String token = ht.DoPostParam();
        return JsonUtils.objectToJson(token);
    }
}
