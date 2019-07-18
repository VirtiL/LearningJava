package strategy_pattern;

/**
 * @Description: 新华三策略
 * @author: zhangcq
 * @Time: 2019-7-18 11:18
 * @Version 1.0
 */
public class H3cStrategy implements Strategy{
    @Override
    public boolean save() {
        System.out.println("新华三考勤");
        return false;
    }
}