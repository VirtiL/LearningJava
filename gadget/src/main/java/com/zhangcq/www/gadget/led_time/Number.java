package com.zhangcq.www.gadget.led_time;

/**
 * @author zhangcq
 * @Description: No Description
 * @Time: 2019/2/26 17:23
 * @Version 1.0
 */
public class Number {

    public static String num0=
            " -- \n" +
            "|  |\n" +
            "    \n" +
            "|  |\n" +
            " -- ";
    public static String num1=
            "    \n" +
            "   |\n" +
            "    \n" +
            "   |\n" +
            "    ";
    public static String num2=
            " -- \n" +
            "   |\n" +
            " -- \n" +
            "|   \n" +
            " -- ";
    public static String num3=
            " -- \n" +
            "   |\n" +
            " -- \n" +
            "   |\n" +
            " -- ";
    public static String num4=
            "    \n" +
            "|  |\n" +
            " -- \n" +
            "   |\n" +
            "    ";
    public static String num5=
            " -- \n" +
            "|   \n" +
            " -- \n" +
            "   |\n" +
            " -- ";
    public static String num6=
            " -- \n" +
            "|   \n" +
            " -- \n" +
            "|  |\n" +
            " -- ";
    public static String num7=
            " -- \n" +
            "   |\n" +
            "    \n" +
            "   |\n" +
            "    ";
    public static String num8=
            " -- \n" +
            "|  |\n" +
            " -- \n" +
            "|  |\n" +
            " -- ";
    public static String num9=
            " -- \n" +
            "|  |\n" +
            " -- \n" +
            "   |\n" +
            " -- ";

    public static String getLED(String format) {
        String sb = "";
        //解析时间
        for (int i=0;i<format.length();i++){
            char c = format.charAt(i);
            String str = String.valueOf(c);
            if(!":".equals(str)){
                String s = find(str);
                if(sb.length() > 0){
                    String[] source = sb.split("\n");
                    String[] find = s.split("\n");
                    String s0 = source[0] + " "+ find[0];
                    String s1 = source[1] + " "+ find[1];
                    String s2 = source[2] + " "+ find[2];
                    String s3 = source[3] + " "+ find[3];
                    String s4 = source[4] + " "+ find[4];
                    sb = s0+"\n"+s1+"\n"+s2+"\n"+s3+"\n"+s4;
                }else{
                    sb = s;
                }
            }else{
                String[] source = sb.split("\n");
                String s0 = source[0] + "   ";
                String s1 = source[1] + " · ";
                String s2 = source[2] + "   ";
                String s3 = source[3] + " · ";
                String s4 = source[4] + "   ";
                sb = s0+"\n"+s1+"\n"+s2+"\n"+s3+"\n"+s4;

            }
        }

        return sb;
    }


    private static String find(String i){
        String ss = "";
        switch (i){
            case "0":
                ss = num0;
                break;
            case "1":
                ss = num1;
                break;
            case "2":
                ss = num2;
                break;
            case "3":
                ss = num3;
                break;
            case "4":
                ss = num4;
                break;
            case "5":
                ss = num5;
                break;
            case "6":
                ss = num6;
                break;
            case "7":
                ss = num7;
                break;
            case "8":
                ss = num8;
                break;
            case "9":
                ss = num9;
                break;
            default:
                break;

        }
        return ss;
    }


}