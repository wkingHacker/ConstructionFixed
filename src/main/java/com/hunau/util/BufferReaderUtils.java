package com.hunau.util;

import java.io.BufferedReader;
import java.util.Objects;

public class BufferReaderUtils {
    public static String read(BufferedReader br){
        StringBuilder sb =new StringBuilder();
        String data="";
        try {
            if (Objects.nonNull(br)){
                while ((data=br.readLine())!=null){
                    sb.append(data);
                }
            }
            return sb.toString();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
