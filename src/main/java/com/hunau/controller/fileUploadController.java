package com.hunau.controller;

import com.bimface.api.bean.response.FileTranslateBean;
import com.bimface.exception.BimfaceException;
import com.bimface.file.bean.FileBean;
import com.bimface.sdk.BimfaceClient;
import com.bimface.sdk.bean.request.FileUploadRequest;
import com.google.gson.Gson;
import com.hunau.bean.fileBean;
import com.hunau.mapper.userMapper;
import com.hunau.util.JsonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.hunau.mapper.userMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author Wking
 * @create 2020-12-07 8:50
 */
@RestController
@RequestMapping("/user")

public class fileUploadController {
    @Autowired
    userMapper userMapper;
@ResponseBody

@RequestMapping("/upload")

    public String upload( @RequestParam("file") MultipartFile file,HttpServletResponse response) throws IOException, BimfaceException, FileUploadException {
        String appkey="EY7zobGomIvkpPWWhuAiDOoR6T59uBEh";
        String appsecret="JLhrYqM4ekxsj2uXfQuoY9gDiz4km4RP";
        BimfaceClient bc = new BimfaceClient(appkey,appsecret);
    //上传文件
    FileBean fileBean = null;
    try {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        System.out.println(file);
            fileUploadRequest.setContentLength(file.getSize());
            fileUploadRequest.setName(file.getOriginalFilename());
            fileUploadRequest.setInputStream(file.getInputStream());

        fileBean = bc.upload(fileUploadRequest);

        System.out.println(fileBean);

    } catch (BimfaceException e) {
        throw e;
    }

    // 获取fileId
    fileBean fb = new fileBean();
    fb.setFileId(fileBean.getFileId());
    fb.setCreateTime(fileBean.getCreateTime());
    fb.setFilename(fileBean.getName());
    fb.setStatus(fileBean.getStatus());
    userMapper.insertfileBean(fb);
    // 发起文件转换
    FileTranslateBean translateBean = null;
    try {
        translateBean = bc.translate(fileBean.getFileId());

    } catch (BimfaceException e) {
    }
    FileTranslateBean translate = bc.getTranslate(fileBean.getFileId());
    System.out.println(translate.getStatus());
    System.out.println(translateBean);
    return JsonUtils.objectToJson(fb);
    }


}
