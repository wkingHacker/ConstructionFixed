package com.hunau.controller;
import com.bimface.api.bean.response.FileTranslateBean;
import com.hunau.bean.fileBean;

import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.hunau.bean.translateBean;
import com.hunau.mapper.userMapper;
import com.hunau.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Wking
 * @create 2020-12-08 14:26
 */
@RestController
@RequestMapping("/user")

public class getTranslateStatusController {

    @Autowired
    userMapper userMapper;
    @ResponseBody
    @RequestMapping("getStatus")
    public String  getStatusInfo() throws BimfaceException {
        BimfaceClient bc = new BimfaceClient("EY7zobGomIvkpPWWhuAiDOoR6T59uBEh","JLhrYqM4ekxsj2uXfQuoY9gDiz4km4RP");
        List<translateBean> all =userMapper.findAll();
        return JsonUtils.objectToJson(all);

    }


}
