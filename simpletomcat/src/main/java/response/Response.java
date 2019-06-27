package response;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description: No Description
 * @author: zhangcq
 * @Time: 2018/12/9 16:57
 * @Version 1.0
 */
public class Response {

    private OutputStream outputStream = null;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writeHtml(String filePath){
        String html = "<html><head><title>test</title></head><body>This is Response!</body></html>";
        try {
            outputStream.write(html.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}