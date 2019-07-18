package strategy_pattern;

/**
 * @Description: 默认策略
 * @author: zhangcq
 * @Time: 2019-7-18 11:18
 * @Version 1.0
 */
public class DefulatStrategy implements Strategy{
    @Override
    public boolean save() {
        System.out.println("默认保存");
        return false;
    }
}