package iot.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import iot.enums.RequestType;
import iot.exception.IOTException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Http请求 辅助类
 */
@Slf4j
public class HttpCfgHelper {

    //    private static final log log = logFactory.getlog(HttpCfgHelper.class);
    private static final int MAX_TIMEOUT = 3000000; //超时时间
    private static final int MAX_TOTAL = 10; //最大连接数
    private static final int ROUTE_MAX_TOTAL = 3; //每个路由基础的连接数
    private static final int MAX_RETRY = 5; //重试次数
    private static PoolingHttpClientConnectionManager connMgr; //连接池
    private static HttpRequestRetryHandler retryHandler; //重试机制

    static {
        cfgPoolMgr();
        cfgRetryHandler();
    }

    /**
     * 不允许外部创建实例
     */
    private HttpCfgHelper() {
    }


    /**
     * @param reqType {@link RequestType} 请求类型  GET、 POST 、 DELETE 、 PUT
     * @param url     {@link String} 请求目标地址
     * @param headers {@link Map} 请求头
     * @param param   {@link Object} 参数
     * @return
     * @throws IOTException
     * @description 发起HTTP / HTTPS 请求
     */
    public static JSONObject sendHttp(RequestType reqType, String url, Map<String, String> headers, Object param)
            throws IOTException {
        return null;
    }

    public static JSONObject sendUploadHttp(RequestType reqType, String url, Map<String, String> headers,
                                            byte[] bytes, String fileName) throws IOTException {
        HttpRequestBase reqBase = reqType.getHttpType(url);
        log.info("--->>开始向地址[{}]发起 [{}] 上传图片请求", url, reqBase.getMethod());
        log.info("--->>请求头为{}", JSON.toJSONString(headers));
        log.info("--->>请求参数为{}", JSON.toJSONString(fileName));
        long startTime = System.currentTimeMillis();
        CloseableHttpClient httpClient = getHttpClient();
        //设置请求url
        config(reqBase);

        //设置请求头 不上传图片的话需要设置请求头,如果上传图片的话,默认的就是from-data格式
//        builder.setContentType(ContentType.create("multipart/form-data; encoding=utf-8"));
//        if (MapUtils.isNotEmpty(headers)) {
//            for (Map.Entry<String, String> entry : headers.entrySet()) {
//                reqBase.setHeader(entry.getKey(), entry.getValue());
//            }
//        }
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setCharset(StandardCharsets.UTF_8);
        //加上此行代码解决返回中文乱码问题
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        // 文件流
//        builder.addBinaryBody("file", bytes, ContentType.DEFAULT_BINARY, fileName);
        builder.addBinaryBody("file", bytes, ContentType.MULTIPART_FORM_DATA, fileName);
//        builder.addTextBody("path", path);
//        builder.addTextBody("filename", filename);
        HttpEntity build = builder.build();
        ((HttpEntityEnclosingRequest) reqBase).setEntity(build);
        //响应对象
        CloseableHttpResponse res = null;
        //响应内容
        String resCtx = null;
        try {
            //执行请求
            res = httpClient.execute(reqBase);
            log.info("--->>执行请求完毕，响应状态：{}", res.getStatusLine());
            if (res.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new IOTException("--->>HTTP访问异常:" + res.getStatusLine());
            }
            //获取请求响应对象和响应entity
            HttpEntity httpEntity = res.getEntity();
            if (httpEntity != null) {
                resCtx = EntityUtils.toString(httpEntity, "utf-8");
                log.info("--->>获取响应内容：{}", resCtx);
            }
        } catch (Exception e) {
            throw new IOTException("请求失败", e);
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (IOException e) {
                    throw new IOTException("--->>关闭请求响应失败", e);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("--->>请求执行完毕，耗费时长：{} 秒", (endTime - startTime) / 1000);
        return JSONObject.parseObject(resCtx);
    }


    /**
     * @param httpReqBase
     * @description 请求头和超时时间配置
     */
    private static void config(HttpRequestBase httpReqBase) {
        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(MAX_TIMEOUT)
                .setConnectTimeout(MAX_TIMEOUT)
                .setSocketTimeout(MAX_TIMEOUT)
                .build();
        httpReqBase.setConfig(requestConfig);
    }

    /**
     * @return
     * @description 连接池配置
     */
    private static void cfgPoolMgr() {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainsf).register("https", sslsf).build();
        //连接池管理器
        connMgr = new PoolingHttpClientConnectionManager(registry);
        //最大连接数
        connMgr.setMaxTotal(MAX_TOTAL);
        //每个路由基础的连接数
        connMgr.setDefaultMaxPerRoute(ROUTE_MAX_TOTAL);
    }


    /**
     * @description 设置重试机制
     */
    private static void cfgRetryHandler() {
        retryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException e, int excCount, HttpContext ctx) {
                //超过最大重试次数，就放弃
                if (excCount > MAX_RETRY) {
                    return false;
                }
                //服务器丢掉了链接，就重试
                if (e instanceof NoHttpResponseException) {
                    return true;
                }
                //不重试SSL握手异常
                if (e instanceof SSLHandshakeException) {
                    return false;
                }
                //中断
                if (e instanceof InterruptedIOException) {
                    return false;
                }
                //目标服务器不可达
                if (e instanceof UnknownHostException) {
                    return false;
                }
                //连接超时
                if (e instanceof ConnectTimeoutException) {
                    return false;
                }
                //SSL异常
                if (e instanceof SSLException) {
                    return false;
                }

                HttpClientContext clientCtx = HttpClientContext.adapt(ctx);
                HttpRequest req = clientCtx.getRequest();
                //如果是幂等请求，就再次尝试
                if (!(req instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };
    }

    /**
     * @return
     * @description 获取HttpClient
     */
    private static CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setConnectionManager(connMgr).setRetryHandler(retryHandler).build();
    }


}
