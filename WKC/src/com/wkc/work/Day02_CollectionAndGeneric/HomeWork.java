package com.wkc.work.Day02_CollectionAndGeneric;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @program: WKC
 * @description: day02 homework
 * @author: Freeze Wu
 * @create: 2019-04-04 17:23
 **/

public class HomeWork {
    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:"+listTest(list, "a"));
        System.out.println("b:"+listTest(list, "b"));
        System.out.println("c:"+listTest(list, "c"));
        System.out.println("xxx:"+listTest(list, "xxx"));


    }


    //统计元素出现次数
    public static int listTest(Collection<String> list, String s){
        int times = 0;

        for(String e : list){
            if(e.equals(s))
                times++;
        }

        return times;
    }
}
