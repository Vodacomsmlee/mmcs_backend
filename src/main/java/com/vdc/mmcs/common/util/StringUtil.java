package com.vdc.mmcs.common.util;


import java.io.*;
import java.util.UUID;

public class StringUtil {
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
