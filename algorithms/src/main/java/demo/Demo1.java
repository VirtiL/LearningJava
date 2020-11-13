package demo;

/**
 * @Description: 两个大数相加
 * @author: zhangcq
 * @Time: 2019-7-19 21:45
 * @Version 1.0
 */
public class Demo1 {

    public static void main(String[] args) {
        String a = "99999999999999999999999999999999999999999999999999999999999999999999999997498";
        String b = "4568";
        //求a+b的值
        String rrr = add(a,b);
        System.out.println(rrr);
    }

    private static String add(String a, String b) {


        StringBuffer aa = new StringBuffer(a);
        StringBuffer reverse_aa = aa.reverse();
        StringBuffer bb = new StringBuffer(b);
        StringBuffer reverse_bb = bb.reverse();

        int max = Math.max(reverse_aa.length(), reverse_bb.length());
        int min = Math.min(reverse_aa.length(), reverse_bb.length());
        StringBuffer sb = new StringBuffer(max+1);

        int sss = 0;
        for (int i=0;i<min;i++){
            int aaa = Integer.parseInt(String.valueOf(reverse_aa.charAt(i)));
            int bbb = Integer.parseInt(String.valueOf(reverse_bb.charAt(i)));
            int ccc = aaa + bbb +sss;
            sss = ccc / 10;
            sb.append((ccc%10));
        }
        String substring = "";
        if(reverse_aa.length() > reverse_bb.length()){
            substring = reverse_aa.substring(reverse_bb.length(), reverse_aa.length());
        }else{
            substring = reverse_bb.substring(reverse_aa.length(), reverse_bb.length());
        }

        for (int i=0;i<substring.length();i++){
            int aaa = Integer.parseInt(String.valueOf(substring.charAt(i)))+ sss;
                sss = aaa / 10;
                sb.append((aaa%10));
        }
        if(sss > 0){
            sb.append(sss);
        }
        return sb.reverse().toString();
    }
}