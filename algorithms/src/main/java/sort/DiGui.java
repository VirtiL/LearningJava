package sort;

/**
 * @Description:    斐波那契数列
 * @author: zhangcq
 * @Time: 2019-7-19 16:30
 * @Version 1.0
 */
public class DiGui {


    public static void main(String[] args) {
        int i = 1;
        for (i = 1; i <= 20; i++) {
            System.out.println("兔子第" + i + "个月的总数为:" + add(i));
        }
    }
    public static int add(int x) {
        if (x == 1 || x == 2) {
            return 1;
        } else {
            return add(x - 1) + add(x - 2);
        }
    }



}