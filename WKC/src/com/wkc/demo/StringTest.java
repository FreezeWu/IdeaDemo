package com.wkc.demo;

public class StringTest {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str);
        str = "123456";
        System.out.println(str);
        StringBuilder stringBuilder = new StringBuilder();

        int i = 321123;

        stringBuilder.append(i);

        System.out.println(stringBuilder);

        System.out.println("------------------------------------------");

        String s1="a"+"b"+"c";
        String s2="abc";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        System.out.println("------------------------------------------");

        String str1="ab";
        String str2="abc";
        String str3=str1+"c";
        System.out.println(str3==str2);         // false
        System.out.println(str3.equals(str2));  // true


    }
}
