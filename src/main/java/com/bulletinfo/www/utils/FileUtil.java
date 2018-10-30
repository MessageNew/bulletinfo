package com.bulletinfo.www.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FileUtil {

    /**
     * 	文件上传工具
     * @param file     文件主体
     * @param filePath 文件储存路径
     * @param fileName 文件名
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();

    }

    /**
     * 生成UUID
     *
     * @return UUID
     */
    public static String generateGUID() {
        return new BigInteger(50, new Random()).toString(36).toUpperCase();
    }

    public static Map<String, Object> deleteFile(String path) {
        Map<String, Object> map = new HashMap<>();
        try {
            File file = new File(path);
            if(!file.exists()) {
                map.put("code", "404");
            }else {
                file.delete();
                path = StringUtils.substringBeforeLast(path,"\\");
                file = new File(path);
                File[] files = file.listFiles();
                if(files.length == 0) {
                    file.delete();
                }
                map.put("code", "200");
            }
        } catch (Exception e) {
            map.put("code", "500");
            e.printStackTrace();
        }

        return map;
    }

}
