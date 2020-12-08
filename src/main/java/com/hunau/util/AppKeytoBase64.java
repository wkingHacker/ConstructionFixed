package com.hunau.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @author Wking
 * @create 2020-12-04 21:10
 */
public class AppKeytoBase64 {
    public static String encode(String appkey,String appsecret) throws UnsupportedEncodingException {
        String pre="Basic"+" ";
            String str = appkey+":"+appsecret;
        byte[] bytes = str.getBytes();
        String encode = Base64.encodeBase64String(bytes);
        return encode;

    }
}
