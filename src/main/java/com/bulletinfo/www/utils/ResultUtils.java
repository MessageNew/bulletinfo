package com.bulletinfo.www.utils;

import com.bulletinfo.www.domain.Result;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Mysteriouseyes on 2018/9/6.
 */
public class ResultUtils {
    public static Result success(Object object){
        try {
            object = jdkMD5(object.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result filed(Object object){
        try {
            object = jdkMD5(object.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setCode(202);
        result.setMsg("失败");
        result.setData(object);
        return result;
    }

    /** jdk实现MD5加密 */
    public static Object jdkMD5(String src) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md.digest(src.getBytes());
        return Hex.encodeHexString(md5Bytes);
    }

}
