package pailiezuhe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 排列组合,n选无重复
 *
彩票的注数算法
    本程序的思路是开一个数组b，其长度和数据数组一致，其前N位为1，N就是要取的数的个数，
    然后按照b的数据为1的下标来取数据数组的数字
    然后从左到右扫描数组b元素值的“10”组合，找到第一个“10”组合后将其变为“01”组合，
    同时将其左边的所有“1”全部移动到数组的最左端，“0”移到所有“1”和变为了“01”的中间
    当b数组最右边的N个元素全部为1时 组合完毕
例如求5中选3的组合：

1 2 3 4 5 <-数组数组
1 1 1 0 0 -->1,2,3
1 1 0 1 0 -->1,2,4
1 0 1 1 0 -->1,3,4
0 1 1 1 0 -->2,3,4
1 1 0 0 1 -->1,2,5
1 0 1 0 1 -->1,3,5
0 1 1 0 1 -->2,3,5
1 0 0 1 1 -->1,4,5
0 1 0 1 1 -->2,4,5
0 0 1 1 1 -->3,4,5

Cnm = n!/(n-m)!
C63 =（6x5x4）÷（3x2x1）=20

 * @author: zhangcq
 * @Time: 2019-6-26 09:42
 * @Version 1.0
 */
public class CaiPiaoZhuShu {

    public static void main(String[] args) {
        String[] a = { "物理", "化学", "生物", "历史", "地理","政治"};
        int num = 3;
        combine(a, num).forEach(item->{
            System.out.println(item);
        });
    }

    /**
     * 实现的算法
     * @param a 数据数组
     * @param num M选N中 N的个数
     * @return
     */
    private static List<String> combine(String[] a, int num) {
        List<String> list = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            if (i < num) {
                b[i] = 1;
            } else{
                b[i] = 0;
            }
        }
        //将 [物理, 化学, 生物, 历史, 地理, 政治] 转换成了 [1, 1, 1, 0, 0, 0]
        System.out.println("将 "+Arrays.toString(a) +" 转换成了 "+Arrays.toString(b));

        //当前指针
        int point = 0;
        //下一个指针
        int nextPoint = 0;
        //计数器
        int count = 0;
        int sum = 0;
        int temp = 1;
        while (true) {
            // 判断是否全部移位完毕
            for (int i = b.length; i > b.length - num; i--) {
                if (b[i-1] == 1){
                    sum += 1;
                }
            }
            // 根据移位生成数据
            for (int i = 0; i < b.length; i++) {
                if (b[i] == 1) {
                    point = i;
                    sb.append(a[point]).append(" ");
                    count++;
                    if (count == num){
                        break;
                    }
                }
            }
            // 往返回值列表添加数据
            list.add(sb.toString());
            System.out.println(sb.toString());

            // 当数组的最后num位全部为1 退出
            if (sum == num) {
                System.out.println("操作完成!");
                break;
            }
            sum = 0;

            // 修改从左往右第一个10变成01
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i] == 1 && b[i + 1] == 0) {
                    point = i;
                    nextPoint = i + 1;
                    b[point] = 0;
                    b[nextPoint] = 1;
                    System.out.println("10变01"+Arrays.toString(b));
                    break;
                }
            }
            System.out.println("point:"+point);
            System.out.println("移位前"+Arrays.toString(b));
            // 将 i-point个元素的1往前移动 0往后移动
            for (int i = 0; i < point - 1; i++){
                for (int j = i; j < point - 1; j++) {
                    if (b[i] == 0) {
                        temp = b[i];
                        b[i] = b[j + 1];
                        b[j + 1] = temp;
                        System.out.println("移位后"+Arrays.toString(b));
                    }
                }
            }

            // 清空 StringBuffer
            sb.setLength(0);
            count = 0;
            System.out.println("===========================");
        }
//        System.out.println("数据长度 " + list.size());
        return list;

    }

}