package com.vdc.mmcs.common.util;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

public class StringUtil {

    public static String getClientIp(HttpServletRequest request) {
        String[] headerNms = new String[]{
                "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR", "X-Real-IP", "X-RealIP"
        };
        String ipAddr = "";

        // get client ip address from header
        for(String nm : headerNms) {
            ipAddr = request.getHeader(nm);
            if (StringUtils.isNotBlank(ipAddr)) {
                break;
            }
        }

        // if ip address is empty, then get client ip from request
        if (StringUtils.isBlank(ipAddr)) {
            ipAddr = request.getRemoteAddr();
        }

        return ipAddr;
    }


    public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static byte[] toByteArray(Object obj)
    {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            bos.close();
            bytes = bos.toByteArray();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    public static Object toObject(byte[] bytes)
    {
        Object obj = null;
        try {
            ObjectInput ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
            obj = ois.readObject();
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return obj;
    }

}
