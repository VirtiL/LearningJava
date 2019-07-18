package observer_pattern.v3;

import observer_pattern.v2.Driver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 交警     具体发布者
 * @author: zhangcq
 * @Time: 2019-7-18 13:19
 * @Version 1.0
 */
public class JingCommander implements Commander {

    //司机列表
    private List<Driver> sijiList = new ArrayList<>();

    //状态
    private String status;


    @Override
    public void changeStatus() {
        this.status = "交警说可以走了      ";
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