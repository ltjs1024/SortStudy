package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;


/**
 * 选择排序
 * 实现思路：
 * 1、
 * 2、
 * 3、
 */
public class SelectSort {

    public static void sort(int[] arr) {
        System.out.println("开始排序：");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }


    public static void sort(DataWrap[] dataWraps) {
        System.out.println("开始排序：");
        int lenth = dataWraps.length;
        for (int i = 0; i < lenth - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lenth; j++) {
                if (dataWraps[i].compareTo(dataWraps[j]) > 0) {
                    DataWrap temp = dataWraps[i];
                    dataWraps[i] = dataWraps[j];
                    dataWraps[j] = temp;
                }
            }
            System.out.println(Arrays.toString(dataWraps));
        }
    }

    public static void sort2(DataWrap[] dataWraps) {
        System.out.println("开始排序：");
        int lenth = dataWraps.length;
        for (int i = 0; i < lenth - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lenth; j++) {
                if (dataWraps[minIndex].compareTo(dataWraps[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                DataWrap temp = dataWraps[i];
                dataWraps[i] = dataWraps[minIndex];
                dataWraps[minIndex] = temp;
            }
            System.out.println(Arrays.toString(dataWraps));
        }
    }
}
