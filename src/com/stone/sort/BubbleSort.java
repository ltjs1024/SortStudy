package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;

/**
 * 冒泡排序
 * 对于一组包含n个数据的一组记录，最坏的情况下，冒泡排序需要进行n-1趟比较
 * 实现思路：
 * 1、第1趟：依次比较0和1、1和2、2和3……n-2和n-1索引的元素，如果发现前一个数据
 * 大于后一个数据，交换它们。经过第1趟，最大的元素排到了最后。
 * 2、第2趟：依次比较0和1、1和2、2和3……n-3和n-2索引的元素，如果发现前一个数据
 * 大于后一个数据，交换它们。经过第2趟，第2大的元素排到了倒数第2位。
 * ……
 * 3、第n-1趟：依次比较0和1索引的元素，如果发现前一个数据
 * 大于后一个数据，交换它们。经过第n-1趟，第2小(第n-1大)的元素排到了第2位。
 * <p>
 * 时间效率：
 * 最优的时间复杂度为：O( n^2 )
 * 最差的时间复杂度为：O( n^2 )；
 * 平均的时间复杂度为：O( n^2 )；
 * 空间效率为O(1)
 * 冒泡排序是稳定的
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        System.out.println("开始排序：");
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 如果j索引处的元素大于j+1索引处的元素
                if (arr[j] > arr[j + 1]) {
                    // 交换它们
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    flag = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            // 如果某趟没有发生交换，则表明已经处于有序状态
            if (!flag) {
                break;
            }
        }


    }


    public static void sort(DataWrap[] dataWraps) {
        System.out.println("开始排序：");
        for (int i = 0; i < dataWraps.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < dataWraps.length - i - 1; j++) {
                if (dataWraps[j].compareTo(dataWraps[j + 1]) > 0) {
                    DataWrap temp = dataWraps[j + 1];
                    dataWraps[j + 1] = dataWraps[j];
                    dataWraps[j] = temp;
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(dataWraps));
            if (!flag) {
                break;
            }
        }

    }


}
