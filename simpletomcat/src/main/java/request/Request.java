package request;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: No Description
 * @author: zhangcq
 * @Time: 2018/12/9 16:57
 * @Version 1.0
 */
public class Request {

//                 GET / HTTP/1.1
//                 Host: localhost:8080
//                 Connection: keep-alive
//                 Cache-Control: max-age=0
//                 Upgrade-Insecure-Requests: 1
//                 User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36
//                 Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//                Accept-Encoding: gzip, deflate, br
//                Accept-Language: zh-CN,zh;q=0.9

    private String URI;

    public Request(InputStream  inputStream) {
        try {
            byte[] buff = new byte[1024];
            int read = 0;
            read = inputStream.read(buff);
            String html = "";
            if(read > 0){
                String text = new String(buff, 0, read);
                System.out.println(text);
                String s = text.substring(text.indexOf("/"),text.indexOf("HTTP/1.1")-1);
                System.out.println(s);
                this.setURI(s);
            }else{
                System.out.println("Bad Request!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }
}