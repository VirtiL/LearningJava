package observer_pattern.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 红绿灯
 * @author: zhangcq
 * @Time: 2019-7-18 13:19
 * @Version 1.0
 */
public class DengCommander implements Commander{

    //司机列表
    private List<Driver> sijiList = new ArrayList<>();

    //状态
    private String status;


    @Override
    public void changeStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void addDriver(Driver driver){
        sijiList.add(driver);
    }

    @Override
    public void notifyDriver(){
        for (Driver o : sijiList) {
            o.run();
        }

    }
}