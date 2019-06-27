package socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-18 16:27
 * @Version 1.0
 */
public class SocketServer {


    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            //阻塞式接收
            Socket accept = serverSocket.accept();

            BufferedReader isr = new BufferedReader(new InputStreamReader(accept.getInputStream()));

            System.out.println(isr.readLine());

            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null ){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}