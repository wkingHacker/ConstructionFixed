package com.hunau.controller;

import com.bimface.sdk.BimfaceClient;
import com.hunau.bean.Token;
import com.hunau.util.JsonUtils;
import com.hunau.util.httpClientDoGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Wking
 * @create 2020-12-05 15:33
 */

@RestController
@RequestMapping("/user")
public class viewTokenController {
  @RequestMapping("/getModelViewToken")
    public String getToken(HttpServletRequest request) throws IOException, URISyntaxException {
    String accessToken = request.getParameter("AccessToken");
    String fileid=request.getParameter("fileid");
    System.out.println(accessToken);
    System.out.println(fileid);
    httpClientDoGet ht = new httpClientDoGet();
    String modelViewtoken = ht.doGetParamOfModelToken(accessToken,fileid);
    return JsonUtils.objectToJson(new Token("ModelView",modelViewtoken));
  }
  @RequestMapping("/getChildFileViewToken")
  public String getChildrenToken(HttpServletRequest request) throws IOException, URISyntaxException {
    String accessToken = request.getParameter("AccessToken");
    String fileid=request.getParameter("fileid");
    String integrateId=request.getParameter("integrateId");
    System.out.println(accessToken);
    System.out.println(fileid);
    httpClientDoGet ht = new httpClientDoGet();
    String ChildFileViewtoken = ht.doPostParamOfChildFileToken(accessToken,fileid,integrateId);
    return JsonUtils.objectToJson(new Token("ChildFileView",ChildFileViewtoken));
  }
}
