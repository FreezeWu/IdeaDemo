package com.wkc.rookie;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest {
    public static void main(String[] args) {
        //初始容量为5，加载因子为0.8
        //当 元素个数 超过 容量长度*加载因子的系数(5*0.8) 时，进行扩容
        //扩容增量：2*原数组长度+1 (原来为5，扩容后为11)
        Hashtable<String, String> userInfo = new Hashtable(5, 0.80f);

        userInfo.put("ldzqjlw38", "atobekeigo" );
        userInfo.put("ldzqjlw39", "abc" );
        userInfo.put("123", "abc" );
        userInfo.put("u4", "p4" );
        userInfo.put("qwer", "123wed" );
        userInfo.put("dsaf", "21ds3!#$" );
        userInfo.put("aaa", "21ds3!#$" );



        System.out.println(userInfo.size());

        System.out.println(userInfo);

        //输出userInfo的键（keys）
        Enumeration keys = userInfo.keys();
        System.out.println("The keys of userInfo: ");
        while (keys.hasMoreElements()){
            System.out.println(keys.nextElement());
        }

        //输出userInfo的枚举值（value）
        Enumeration enumeration = userInfo.elements();
        System.out.println("The value of userInfo: ");
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

    }
}
