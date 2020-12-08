package com.hunau.controller;

import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.hunau.bean.message;
import com.hunau.mapper.userMapper;
import com.hunau.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wking
 * @create 2020-12-08 9:21
 */
@RequestMapping("/user")
@RestController
public class deleteController {
@Autowired
    userMapper userMapper;
    @RequestMapping("/delete")
            public String delete( String fileId) throws BimfaceException {    BimfaceClient bc= new BimfaceClient("EY7zobGomIvkpPWWhuAiDOoR6T59uBEh","JLhrYqM4ekxsj2uXfQuoY9gDiz4km4RP");


            try{
                long f = Long.parseLong(fileId);
                bc.deleteFile(f);
                userMapper.deleteFile(fileId);
                return JsonUtils.objectToJson(new message("删除文件成功",true));

            }
            catch (BimfaceException e){
                throw  e;

            }






    }



}
