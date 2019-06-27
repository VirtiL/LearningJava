package proxy_pattern.dynamic.jdk.v2;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-3-27 09:00
 * @Version 1.0
 */
public class MyProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader loader, Class<?>[] interfaces, MyInvocationHandler h)
            throws IllegalArgumentException {
        //1生成源代码,先弄一个举例子
        String src = createSource(interfaces[0]);
        //2.将生成的源代码写入磁盘,保存为xxx.java
        String path = MyProxy.class.getResource("").getPath();
        File file = new File(path + "$Proxy0.java");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fileWriter){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //3.编译xxx.java文件生成.class文件
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);
        systemJavaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects).call();
        try {
            standardFileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object obj = null;

        //4.将class文件的内容动态加载到JVM中
        try {
            Class<?> classProxy = loader.findClass("$Proxy0");
            Constructor<?> constructor = classProxy.getConstructor(MyInvocationHandler.class);
            obj = constructor.newInstance(h);
            //删除文件,实现隐式
            file.delete();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5.返回被代理后的动态代理对象
        return obj;
    }

    /**
     * 1.生成源代码
     * @param interfaces
     * @return
     */
    private static String createSource(Class<?> interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package proxy_pattern.dynamic.jdk.v2;"+ln);

        sb.append("import java.lang.reflect.Method;"+ln);
        sb.append("import java.lang.reflect.UndeclaredThrowableException;"+ln);
        sb.append("import proxy_pattern.dynamic.jdk.v2.MyInvocationHandler;"+ln);

        sb.append("public class $Proxy0 implements Log { "+ln);

        sb.append("private MyInvocationHandler h; "+ln);

        sb.append("public $Proxy0(MyInvocationHandler h){ "+ln);
        sb.append("     this.h = h; "+ln);
        sb.append("} "+ln);
        //生成方法
        for (Method m : interfaces.getMethods()) {
            //获取参数
            Class[] parameterTypes = m.getParameterTypes();
            //如果是void
            if ("void".equals(m.getReturnType().getName()) || parameterTypes.length == 0) {
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){ " + ln);
            } else {
                String params = "";
                for (int i =0;i<parameterTypes.length;i++){
                    if(i == parameterTypes.length-1){
                        params += parameterTypes[i].getName()+" "+ "par"+i;
                    }else{
                        params += parameterTypes[i].getName()+" "+ "par"+i +", ";
                    }
                }
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "("+params+"){ " + ln);
            }
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            if ("void".equals(m.getReturnType().getName())) {
                sb.append("this.h.invoke(this, m, null);" + ln);
            } else {
                sb.append("return (" + m.getReturnType().getName() + ") this.h.invoke(this, m, null);" + ln);
            }
            sb.append("} catch (Throwable localThrowable){ " + ln);
            sb.append("throw new UndeclaredThrowableException(localThrowable);" + ln);
            sb.append("}" + ln);
            sb.append("} " + ln);
        }

        sb.append("}");

        return sb.toString();
    }
}