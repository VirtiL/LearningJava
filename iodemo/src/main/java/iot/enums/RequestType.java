package iot.enums;

import org.apache.http.client.methods.*;

/**
 * @Description: 请求类型
 * @Author: zhangcq
 * @Time: 2020-9-16 11:26
 */
public enum RequestType {

	POST{
		@Override
		public HttpRequestBase getHttpType(String url) {
			return new HttpPost(url);
		}
	},
	GET{
		@Override
		public HttpRequestBase getHttpType(String url) {
			return new HttpGet(url);
		}
	},
	DELETE{
		@Override
		public HttpRequestBase getHttpType(String url) {
			return new HttpDelete(url);
		}
	},
	PUT{
		@Override
		public HttpRequestBase getHttpType(String url) {
			return new HttpPut(url);
		}
	},
	
	;
	
   public abstract HttpRequestBase getHttpType(String url);
}
