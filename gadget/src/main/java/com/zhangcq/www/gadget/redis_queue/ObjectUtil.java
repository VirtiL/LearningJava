package com.zhangcq.www.gadget.redis_queue;

import java.io.*;

/**
 * @Description: 对象序列化与反序列化
 * @author: zhangcq
 * @Time: 2019-6-26 16:49
 * @Version 1.0
 */
public class ObjectUtil {


    /**
     * 对象序列化
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] object2Byte(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        byte[] bytes=baos.toByteArray();
        baos.close();
        oos.close();
        return bytes;
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object byte2Object(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in=new ByteArrayInputStream(bytes);
        ObjectInputStream sIn=new ObjectInputStream(in);
        return sIn.readObject();
    }




}