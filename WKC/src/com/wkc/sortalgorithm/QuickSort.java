package com.wkc.sortalgorithm;

public class QuickSort {
    public void quickSort(int low, int high, int[] a) {
        int i,j,key,temp;

        if(low > high)
            return;

        i = low;
        j = high;

        key = a[low];

        //一次交换
        while(i < j) {

            //从右往左找小于key的数
            while(a[j] >= key && i < j) {
                j--;
            }

            //从左往右找大于key的数
            while(a[i] <= key && i < j) {
                i++;
            }

            //交换
            if(i < j) {
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }

        a[low] = a[i];
        a[i] = key;

        quickSort(low, j-1, a);
        quickSort(j+1, high, a);

    }

    public void print(int[] a) {
        for(int element: a) {
            System.out.println(element);
        }
    }

}
