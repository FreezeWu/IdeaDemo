package com.wkc.sortalgorithm;

/**
 * 插入排序：
 * 1、以数组的某一位作为分隔位，比如index=1，假设左面的都是有序的.
 *
 * 2、将index位的数据拿出来，
 *
 * 3、从leftIndex=index-1开始将左面的数据与当前index位的数据进行比较，如果array[leftIndex]>array[Index],
 * 则将array[leftIndex]和array[index]交换，即array[leftIndex+1]=array[leftIndex].
 *
 * 4、再用index-2(即leftIndex=leftIndex-1)位的数据和index比，重复步骤3，
 * 直到找到<=temp的数据或者比到了最左面（说明index最小），停止比较.
 *
 * 5、index向后挪1，即index=index+1，也就是开始选择第三位数,重复步骤2-4，直到index=array.length,排序结束，
 * 此时数组中的数据即为从小到大的顺序.
 *
 *
 */

public class InsertSort {

}
