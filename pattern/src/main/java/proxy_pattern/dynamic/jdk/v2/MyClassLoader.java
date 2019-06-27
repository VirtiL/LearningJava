package proxy_pattern.dynamic.jdk.v2;

import java.io.*;

/**
 * @Description: 自定义类加载器
 * @author: zhangcq
 * @Time: 2019-3-27 09:01
 * @Version 1.0
 */
public class MyClassLoader extends ClassLoader{

    private File baseDir;

    public MyClassLoader() {
        //获取对应的文件夹地址
        String basePath = MyClassLoader.class.getResource("").getPath();
        System.out.println("basePath: "+basePath);
        this.baseDir = new File(basePath);

    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        //获取对应的文件地址
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        System.out.println("className: "+className);
        if (null != baseDir){
            //地址转换
            String classPath = name.replaceAll("\\.", "/")+".class";
            System.out.println("classPath:  "+classPath);
            System.out.println("path:  "+baseDir+"\\"+classPath);
            File classFile = new File(baseDir+"\\"+classPath);
            //如果存在源文件就加载到jvm中
            if(classFile.exists()){
                FileInputStream fileInputStream = null;
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    fileInputStream = new FileInputStream(classFile);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int length;
                    while ((length = fileInputStream.read(buff)) != -1){
                        byteArrayOutputStream.write(buff,0,length);
                    }
                    //加载到JVM中并返回
                    return defineClass(className,byteArrayOutputStream.toByteArray(),0,byteArrayOutputStream.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(null != fileInputStream){
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(null != byteArrayOutputStream){
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    //删除文件,实现隐式
                    classFile.delete();
                }

            }

        }


        return null;
    }
}