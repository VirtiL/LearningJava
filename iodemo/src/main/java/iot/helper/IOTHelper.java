package iot.helper;

import com.alibaba.fastjson.JSONObject;
import iot.CommonConfigConstant;
import iot.enums.RequestType;
import iot.exception.IOTException;

/**
 * @Description: iot对接辅助类
 * @Author: zhangcq
 * @Time: 2020-9-29 09:57
 */
public class IOTHelper {

//    private static final String domain = "http://hlink.nat300.top";
//    private static final String domain = "http://localhost";

    /**
     * 1. 人脸识别图片上传`uri: /api/saas/deepeix/file/upload`（接口请求格式FormData）
     * <p>
     * | 请求字段名称 | 字段类型 | 是否必填 | 描述                             |
     * | ------------ | -------- | -------- | -------------------------------- |
     * | file         | file     | 是       | 图片文件，图片类型只允许png、jpg |
     * <p>
     * ```
     * Response
     * {
     * "code": "200",
     * "msg": "文件上传成功",
     * "data": {
     * "imgId": "",	//图片ID，字符串类型
     * "imgName": ""	//图片名称，字符串类型
     * }
     * }
     * ```
     *
     * @param bytes
     * @param fileName
     * @throws IOTException
     */
    public static JSONObject streamUpload(String domain, byte[] bytes, String fileName) throws IOTException {
        JSONObject json = HttpHelper.doUploadImageHttp(RequestType.POST, domain + CommonConfigConstant.deepeixFileUpload(), bytes, fileName);
        return JSONHelper.castDataJson(json, JSONObject.class);
    }

    private static final String domain = "http://iot.beingcospace.com:8190";

    public static void main(String[] args) throws IOTException {
        byte[] download = HttpDownload.download("https://image.domesee.com/d45d2b25-4acf-4ebb-84d2-099824ab2065.jpg?imageMogr2/auto-orient/thumbnail/!600x600r");
        System.out.println("要上传的图片大小是:"+download.length);
        streamUpload(domain, download, "18621861800.jpg");
    }


}
