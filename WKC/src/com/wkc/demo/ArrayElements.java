package com.wkc.demo;
/*
(1)定义一个int类型的数组，内容为{6,2,9,15,1,5,20,7,18}
	(2)将数组最大元素与最后一位元素进行交换,最小元素与第一位元素进行交换，并打印数组
	提示思路：先查找最大值和最小值出现的索引。
*/


public class ArrayElements {


    public static void main(String[] args) {
        int[] a = {6,2,9,15,1,5,20,7,18};

        int max = a[0], min = a[0];
        int maxIndex = 0, minIndex = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] > max){
                max = a[i];

                maxIndex = i;
            }
        }

        for(int i = 0; i < a.length; i++){
            if(a[i] < min){
                min = a[i];
                minIndex = i;
            }
        }

        int temp = a[0];
        a[0] = min;
        a[minIndex] = temp;

        temp = a[a.length - 1];
        a[a.length - 1] = max;
        a[maxIndex] = temp;

        for(int element : a){
            System.out.println(element);
        }


    }

}
