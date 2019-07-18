package bio;

import java.io.*;
import java.net.Socket;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-3 15:38
 * @Version 1.0
 */
public class BIOClient {


    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost",5555);
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            InputStreamReader inr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(inr);
            String s = br.readLine();
            bufferedWriter.write(s);
            bufferedWriter.flush();
            out.close();
            outputStreamWriter.close();
            bufferedWriter.close();
            br.close();
            inr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket == null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}