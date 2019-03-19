package com.wkc.demo;

import java.util.HashMap;
import java.util.Hashtable;



public class PackageDemo {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Hashtable hashtable = new Hashtable();

        hashMap.put("leader", "taeyeon");
        hashMap.put("appearance", "yoona");
        hashMap.put(1.10, "yoona");
        hashMap.put("temp", null);
        hashMap.put(null, null);
        hashMap.put(null, null);
        hashMap.putAll(hashtable);

        hashtable.put(1, "yoshina");
        //hashtable.put(null, null);    错误用法，Hashtable不允许使用null键或null值

        for(Object key : hashMap.keySet()){
            System.out.println(key + ": " + hashMap.get(key));
        }

    }


}
