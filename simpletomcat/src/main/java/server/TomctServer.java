package server;
import request.Request;
import response.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: No Description
 * @author: zhangcq
 * @Time: 2018/12/9 20:00
 * @Version 0.2
 */
public class TomctServer {

    private static int count = 0;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            //1.建立服务器
            serverSocket = new ServerSocket(8080);
            while (true){
                //阻塞式接收客户端
                socket = serverSocket.accept();
                count ++;
                //2.获取请求
                InputStream inputStream = socket.getInputStream();
                Request request = new Request(inputStream);
                String uri = request.getURI();
                //3.响应
                OutputStream outputStream = socket.getOutputStream();
                Response response = new Response(outputStream);
                response.writeHtml("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}