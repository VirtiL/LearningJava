package iot.helper;

import com.alibaba.fastjson.JSONObject;
import iot.exception.IOTException;

/**
 * @description JSON 处理辅助类
 */
public class JSONHelper {

    private JSONHelper() {
    }

    /**
     * @param json
     * @return
     * @throws IOTException
     * @description 格式化json data数据
     */
    @SuppressWarnings("unchecked")
    public static <T> T castDataJson(JSONObject json, Class<T> clz) throws IOTException {
        int code = json.getIntValue("code");
        if (code != 200) {
            throw new IOTException(json.getString("msg"));
        }
        Object obj = json.get("data");
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }

    /**
     * @param json
     * @return
     * @throws IOTException
     * @description 格式化json data数据
     */
    @SuppressWarnings("unchecked")
    public static String castDataListJson(JSONObject json) throws IOTException {
        int code = json.getIntValue("code");
        if (code != 200) {
            throw new IOTException(json.getString("msg"));
        }
        Object dataList = json.get("dataList");
        if (dataList == null) {
            return "";
        }
        return dataList.toString();
    }
}
