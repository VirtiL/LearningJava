package sort;

import java.io.File;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-19 20:59
 * @Version 1.0
 */
public class Digui2 {

    public static void main(String[] args) {
        File file = new File("E:\\opt");
        to(file);

    }


    public static void to(File file){
        if(file.exists()){
            File[] files = file.listFiles();
            if(null != files && files.length > 0){
                for (File f : files) {
                    if(f.isDirectory()){
                        to(f);
                    }
                    if(f.isFile()){
                        System.out.println(f.getName());
                        System.out.println(f.getAbsolutePath());
                    }

                }
            }
        }
    }


}