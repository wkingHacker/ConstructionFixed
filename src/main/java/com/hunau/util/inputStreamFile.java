package com.hunau.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Wking
 * @create 2020-12-07 21:22
 */
public class inputStreamFile {
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
