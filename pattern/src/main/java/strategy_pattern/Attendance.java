package strategy_pattern;

/**
 * @Description: 环境类
 * @author: zhangcq
 * @Time: 2019-7-18 11:20
 * @Version 1.0
 */
public class Attendance {


    private Strategy strategy;


    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean exe(){
        return strategy.save();
    }



}