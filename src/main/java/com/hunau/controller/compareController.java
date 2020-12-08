package com.hunau.controller;

import com.bimface.api.bean.response.ModelCompareBean;
import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.hunau.bean.CompareRequest;
import com.hunau.util.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wking
 * @create 2020-12-07 9:19
 */
@RestController
@RequestMapping("/user")
public class compareController {
    @ResponseBody
    @RequestMapping("/compareV2")
    public String compare(Long previousId,Long followingId) throws BimfaceException {String appkey="EY7zobGomIvkpPWWhuAiDOoR6T59uBEh";
        String appsecret="JLhrYqM4ekxsj2uXfQuoY9gDiz4km4RP";
        BimfaceClient bc = new BimfaceClient(appkey,appsecret);
        ModelCompareBean modelCompareBean = bc.compareV2(new CompareRequest(2011799707592896L,2011799873030336L));
        return JsonUtils.objectToJson(modelCompareBean);

    }
}
