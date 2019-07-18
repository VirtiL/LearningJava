package strategy_pattern;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-18 11:11
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {

        Attendance attendance = new Attendance();
        H3cStrategy h3cStrategy = new H3cStrategy();
        attendance.setStrategy(h3cStrategy);
        attendance.exe();


    }

}