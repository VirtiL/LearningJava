package iot.helper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-17 13:36
 */
public class HttpDownload {


    /**
     * 获取网络文件的字节数组
     *
     * @param url
     * @return
     */
    public static byte[] download(String url) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = client.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] bytes = new byte[is.available()];
            int n = 0;
            while (-1 != (n = is.read(bytes))) {
                output.write(bytes, 0, n);
            }
            return output.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void download(String url, String filepath) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = client.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            File file = new File(filepath);
            boolean mkdirs = file.getParentFile().mkdirs();
            FileOutputStream fileout = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int ch = 0;
            while ((ch = is.read(buffer)) != -1) {
                fileout.write(buffer, 0, ch);
            }
            is.close();
            fileout.flush();
            fileout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}