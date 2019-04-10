package com.wkc.rookie;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        //使用泛型数组打印时，需要使用包装类
        Integer[] ints = {1, 3, 5, 6, 7};
        String[] strings = {"aaa", "bbb", "ccc"};
        Double[] doubles = {1.11, 2.333, 6.666};

        printArray(ints);
        printArray(strings);
        printArray(doubles);

        System.out.println("------------------------------------------");
        try {
            System.out.println(maximum(1, 3, 5));
            System.out.println(maximum("abc", "123", "a123"));
            System.out.println(maximum(true, false, true));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("------------------------------------------");

        Box objectBox = new Box();
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        ArrayList arrayList = new ArrayList();
        arrayList.add(111);
        arrayList.add("abc");

        objectBox.setT(arrayList);
        ArrayList arrayList1 = (ArrayList) objectBox.getT();
        System.out.println(arrayList1);

        integerBox.setT(new Integer(10));
        stringBox.setT(new String("Yoshina"));

        System.out.println(integerBox.getT());
        System.out.println(stringBox.getT());

        System.out.println("------------------------------------------");

        ArrayList<Integer> integerList= new ArrayList<>();
        ArrayList<String> stringList= new ArrayList<>();
        ArrayList<Number> numberList= new ArrayList<>();

        integerList.add(111);
        stringList.add("Kurumi");
        numberList.add(3.333);

        getData(integerList);
        getData(stringList);
        getData(numberList);

        getUpperNumber(integerList);
        getUpperNumber(numberList);
    }

    //打印泛型数组
    public static <T> void printArray(T[] array){
        for(T element : array){
            //System.out.println(element);
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    //返回3个继承于Comparable接口的泛型类的最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;

        if(y.compareTo(x) > 0){
            max = y;
        }

        if(z.compareTo(max) > 0){
            max = z;
        }

        return max;
    }

    //参数为泛型List
    public static void getData(ArrayList<?> data){
        System.out.println("data: " + data.get(0));
    }

    //<? extends T>表示该通配符所代表的类型是T类型的子类
    //<? super T>表示该通配符所代表的类型是T类型的父类
    //参数为继承于Number类的泛型List
    public static void getUpperNumber(ArrayList<? extends Number> data){
        System.out.println("data: " + data.get(0));
    }

}

//泛型类盒子，可以装各种类型
class Box<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}