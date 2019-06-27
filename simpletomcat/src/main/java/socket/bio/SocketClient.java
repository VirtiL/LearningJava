package socket.bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-18 16:33
 * @Version 1.0
 */
public class SocketClient {


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            //写完清空缓冲区,defaultCharBufferSize = 8192;
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("Hello!");
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}