package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;

/**
 * 冒泡排序
 * 对于一组包含n个数据的一组记录，最坏的情况下，冒泡排序需要进行n-1趟比较
 * 实现思路：
 * 1、
 * 2、
 * 3、
 */
public class BubbleSort {


    public static void sort(int[] arr) {
        System.out.println("开始排序：");
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    flag = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!flag) {
                break;
            }
        }


    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
