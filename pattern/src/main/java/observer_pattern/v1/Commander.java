package observer_pattern.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 指挥者
 * @author: zhangcq
 * @Time: 2019-7-18 13:05
 * @Version 1.0
 */
public class Commander {

    //司机列表
    private List<Driver> sijiList = new ArrayList<>();

    //状态
    private String status;

    public String getStatus() {
        return status;
    }

    public void changeStatus(String status) {
        this.status = status;
    }

    public void addDriver(Driver driver){
        sijiList.add(driver);
    }

    public void notifyDriver(){
        for (Driver o : sijiList) {
            o.run();
        }

    }


}