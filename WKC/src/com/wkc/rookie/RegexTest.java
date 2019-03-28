package com.wkc.rookie;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
常用正则表达式：

只能输入数字："^[0-9]*$"。
只能输入n位的数字："^\d{n}$"。
只能输入至少n位的数字："^\d{n,}$"。
只能输入m~n位的数字：。"^\d{m,n}$"
只能输入零和非零开头的数字："^(0|[1-9][0-9]*)$"。
只能输入有两位小数的正实数："^[0-9]+(.[0-9]{2})?$"。
只能输入有1~3位小数的正实数："^[0-9]+(.[0-9]{1,3})?$"。
只能输入非零的正整数："^\+?[1-9][0-9]*$"。
只能输入非零的负整数："^\-[1-9][]0-9"*$。
只能输入长度为3的字符："^.{3}$"。
只能输入由26个英文字母组成的字符串："^[A-Za-z]+$"。
只能输入由26个大写英文字母组成的字符串："^[A-Z]+$"。
只能输入由26个小写英文字母组成的字符串："^[a-z]+$"。
只能输入由数字和26个英文字母组成的字符串："^[A-Za-z0-9]+$"。
只能输入由数字、26个英文字母或者下划线组成的字符串："^\w+$"。
验证用户密码："^[a-zA-Z]\w{5,17}$"正确格式为：以字母开头，长度在6~18之间，只能包含字符、数字和下划线。
验证是否含有^%&',;=?$\"等字符："[^%&',;=?$\x22]+"。
只能输入汉字："^[\u4e00-\u9fa5]{0,}$"
验证Email地址："^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"。
验证InternetURL："^http://%28[/\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$"。
验证电话号码："^(\(\d{3,4}-)|\d{3.4}-)?\d{7,8}$"正确格式为："XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"。
验证身份证号（15位或18位数字）："^\d{15}|\d{18}$"。
验证一年的12个月："^(0?[1-9]|1[0-2])$"正确格式为："01"～"09"和"1"～"12"。
验证一个月的31天："^((0?[1-9])|((1|2)[0-9])|30|31)$"正确格式为；"01"～"09"和"1"～"31"

验证QQ号码（必须是5~15位数字，0不能开头）："[1-9][0-9]{4,14}"
*/

public class RegexTest {
    public static void main(String[] args) {
        //匹配纯字母的字符串
        String pattern = "^[a-zA-Z]+$";

        System.out.println("please input a String: ");

        String inputContent = new Scanner(System.in).nextLine();

        boolean match = Pattern.matches(pattern, inputContent);

        //当不匹配时重新输入
        while(!match){
            System.out.println("Not match, please re-input: ");

            inputContent = new Scanner(System.in).nextLine();

            match = Pattern.matches(pattern, inputContent);
        }

        System.out.println(match);

        System.out.println("------------------------------------------");

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern2 = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern2);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

        System.out.println("------------------------------------------");

        //小括号分组：数左边的小括号第几个就是第几组

        //第一组匹配2个数组的字符串，第二组匹配2到3个小写字母的字符串
        Pattern p = Pattern.compile("(\\d{2})([a-z]{2,3})");
        Matcher m2 =p.matcher("33aa-32sdy-29ssc");
        while(m2.find()) {
            System.out.println(m2.group(2));//每次匹配获取第二组内容
        }
        /*
        输出结果：
        aa
        sdy
        ssc
         */


        //向前引用：
        Pattern p2 = Pattern.compile("(\\d(\\d))\\2");
        Matcher matcher = p2.matcher("211");
        System.out.println(matcher.matches());
        //结果：true
        //解释："\\2"代表引用前面的第2组匹配的值






    }
}
