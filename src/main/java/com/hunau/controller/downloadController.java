package com.hunau.controller;

import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.hunau.util.JsonUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

/**
 * @author Wking
 * @create 2020-12-08 9:32
 */
@RestController
@RequestMapping("/user")
public class downloadController {
    @RequestMapping("/download")
    public void download(String fileId,String filename,HttpServletResponse response) throws BimfaceException, IOException {try{

        BimfaceClient bc = new BimfaceClient("EY7zobGomIvkpPWWhuAiDOoR6T59uBEh","JLhrYqM4ekxsj2uXfQuoY9gDiz4km4RP");

        Long l= Long.parseLong(fileId);
        InputStream downloadIs = bc.download(l, filename);
        File targetFile = new File("D:\\code\\downloadFile\\"+filename);
        FileUtils.copyInputStreamToFile(downloadIs, targetFile);
        response.setContentType("multipart/form-data");
        ServletOutputStream out = null;
        FileInputStream in = null;
        String filePath = targetFile.getAbsolutePath();
        filePath = URLDecoder.decode(filePath,"UTF-8");
        in = new FileInputStream(new File(filePath));
        String[] dir = filePath.split("/");
        String fileName = dir[dir.length-1];
        response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
        out = response.getOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024 * 10];
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.flush();
        out.close();
        in.close();

    }

    catch (BimfaceException e){
        throw  e;
    }


    }
}
