package com.wkc.work.Day02_CollectionAndGeneric;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @program: WKC
 * @description: Day02 -- Collection and Generic
 * @author: Freeze Wu
 * @create: 2019-04-04 10:26
 **/

public class CollectionAndGeneric {
    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList();
        ((ArrayList<Integer>) list1).add(0, 666);
        getElement(list1);
        getElement2(list1);
        Collection<String> list2 = new ArrayList();
        ((ArrayList<String>) list2).add(0, "666");
        getElement(list2);
        getElement2(list2);

        Collection list3 = new ArrayList();
        ((ArrayList) list3).add(0, 666);
        getElement(list3);
        getElement2(list3);
    }

    public static void getElement(Collection<?> coll){
        System.out.println(coll);
    }

    public static <E> void getElement2(Collection<E> coll){
        System.out.println(coll);
        //coll.add(666);
    }
}
