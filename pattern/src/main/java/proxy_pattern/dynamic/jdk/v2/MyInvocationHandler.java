package proxy_pattern.dynamic.jdk.v2;

import java.lang.reflect.Method;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-3-27 09:02
 * @Version 1.0
 */
public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}