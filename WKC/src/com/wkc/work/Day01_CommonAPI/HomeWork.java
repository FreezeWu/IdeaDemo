package com.wkc.work.Day01_CommonAPI;

import java.util.Calendar;

/**
 * @program: WKC
 * @description: homework of Day01
 * @author: Freeze Wu
 * @create: 2019-04-03 20:46
 **/

public class HomeWork {
    static int i= 1;
    public static void main(String args[]){
//        System.out.println("love " + new HomeWork());//love java
//        HomeWork a = new HomeWork();
//        a.i++;
//        System.out.println("me " + a.i);//me 2

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 1, 14);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); //4, means Wednesday

        System.out.println("------------------------------------------");

        char[] chars = {'i', 't', 'c', 'a', 's', 'a'};
        System.arraycopy(chars, 1, chars, 5, 1);
        System.out.println(chars);

        System.out.println("------------------------------------------");

        String str = "";
        StringBuilder sb = new StringBuilder("");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            str += "Taenggu";
        }
        long end = System.currentTimeMillis();

        System.out.println("String += 10000 times cost " + (end - start) / 1000.0 + "s");

        long start1 = System.currentTimeMillis();
        for (int j = 0; j < 10000; j++) {
            sb.append("Taenggu");
        }
        long end1 = System.currentTimeMillis();

        System.out.println("StringBuilder append 10000 times cost " + (end1 - start1) / 1000.000000 + "s");

        System.out.println("------------------------------------------");

        //练习十：StringBuilder类的使用（reverse()方法）
        //十、分析以下需求，并用代码实现：
        //	(1)定义数字字符串数组{"010","3223","666","7890987","123123"}；
        //	(2)判断该数字字符串数组中的数字字符串是否是对称(第一个数字和最后一个数字相等，第二个数字和倒数第二个数字是相等的，依次类推)的，并逐个输出；
        //	(3)如：010 是对称的，3223 是对称的，123123 不是对称的；
        //	(4)最终打印该数组中对称字符串的个数。
        //注：判断对称可用reverse(),将此字符序列用其反转形式取代。
        String[] strings = {"010","3223","666","7890987","123123"};
        int nums = 0;

        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            sb1.replace(0, sb1.length(), strings[i]);
            String str1 = sb1.toString();
            String str2 = sb1.reverse().toString();
            if(str1.equals(str2)){
                nums++;
            }

        }
        System.out.println(nums);

        System.out.println("------------------------------------------");

        //练习十一：StringBuilder类的使用
        //十一、分析以下需求，并用代码实现：
        //		(1)打印由7，8，9三个数组成的三位数，要求该三位数中任意两位数字不能相同；
        //		(2)打印格式最后的三位数字以空格分隔，如789 798 879 897 978 987。
        //注：要求使用StringBuilder来完成

        String s = "789";
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            //遍历字符串s，把字符依次添加到StringBuilder内，组成一个元素
            for (int j = 0; j < s.length(); j++) {
                sb2.append(s.charAt(j));
            }

            //当StringBuilder内元素为一个和两个时，需要加空格来隔开元素
            if(i != 2){
                sb2.append(" ");
            }

            //把字符串s的第一个元素切割，添加到字符串末位，组成新的字符串
            s = s.substring(1).concat(s.substring(0, 1));
        }

        s = sb2.toString() + " " + sb2.reverse().toString();
        System.out.println(s);

    }



    public String toString(){
        System.out.print("I ");//I
        return "java ";
    }

}
