package singleton.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-25 16:21
 * @Version 1.0
 */
public class MapSingleton {


    private static Map<String,MapSingleton> map = new ConcurrentHashMap<>();

    private MapSingleton(){}

    private static MapSingleton getInstance(String name){
        if (name == null){
            name = MapSingleton.class.getName();
        }
        if(map.get(name) == null){
            try {
                map.put(name, (MapSingleton) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }

}