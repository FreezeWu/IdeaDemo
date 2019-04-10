package com.wkc.rookie;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        //初始容量为3，每次容量溢出时增加2容量
        Vector<Integer> vector = new Vector<>(3, 2);

        System.out.println(vector.capacity());

        vector.add(1);
        vector.add(3);
        vector.add(5);
        vector.add(7);

        System.out.println(vector);

        Enumeration enu = vector.elements();

        while (enu.hasMoreElements()){
            System.out.println(enu.nextElement());
        }

        //迭代器遍历集合
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
