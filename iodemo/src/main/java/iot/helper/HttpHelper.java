package iot.helper;

import com.alibaba.fastjson.JSONObject;
import iot.enums.RequestType;
import iot.exception.IOTException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;

import java.util.HashMap;
import java.util.Map;

/**
 * Http 请求 辅助类
 */
@Slf4j
public class HttpHelper {

    /**
     * json
     *
     * @param reqType  请求方式
     * @param url      请求路径
     * @param paramStr 请求参数
     * @return
     * @throws IOTException
     * @description 发送常规HTTP 请求
     */
    public static JSONObject doJsonHttp(RequestType reqType, String url, String paramStr) throws IOTException {
        Map<String, String> header = new HashMap<>();
//        header.put("Authentication","token");
        header.put("Content-Type", ContentType.APPLICATION_JSON.getMimeType());
        return HttpCfgHelper.sendHttp(reqType, url, header, paramStr);
    }

    /**
     * FormData
     *
     * @param reqType
     * @param url
     * @param fileName
     * @return
     * @throws IOTException
     */
    public static JSONObject doUploadImageHttp(RequestType reqType, String url, byte[] bytes, String fileName) throws IOTException {
        Map<String, String> header = new HashMap<>();
//        header.put("Authentication","token");
        return HttpCfgHelper.sendUploadHttp(reqType, url, header, bytes, fileName);
    }


}
