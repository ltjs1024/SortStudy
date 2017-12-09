package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;

/**
 * 快速排序
 * Created by stone on 2017/12/9.
 */
public class QuickSort {

    public static void sort(int[] arr) {
        System.out.println("开始排序");
        subSort(arr, 0, arr.length - 1);
    }

    private static void subSort(int[] arr, int start, int end) {

        if (start < end) {
            int base = arr[start];

            int i = start;
            int j = end + 1;

            while (true) {

                while (i < end && arr[++i] < base) ;

                while (j > start && arr[--j] > base) ;

                if (i < j) {
                    swap(arr, i, j);
                } else {
                    break;
                }
                System.out.println(Arrays.toString(arr));
            }
            // 交换
            swap(arr, start, j);
            System.out.println(Arrays.toString(arr));

            // 递归左子序列
            subSort(arr, start, j - 1);
            // 递归右子序列
            subSort(arr, j + 1, end);


        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void sort(DataWrap[] dataWraps) {
        System.out.println("开始排序");
        subSort(dataWraps, 0, dataWraps.length - 1);
    }

    public static void subSort(DataWrap[] dataWraps, int start, int end) {
        if (start < end) {
            DataWrap base = dataWraps[start];
            int i = start;
            int j = end + 1;
            while (true) {
                while (i < end && dataWraps[++i].compareTo(base) <= 0) ;
                while (j > start && dataWraps[--j].compareTo(base) >= 0) ;

                if (i < j) {
                    swap(dataWraps, i, j);
                } else {
                    break;
                }
                System.out.println(Arrays.toString(dataWraps));
            }

            swap(dataWraps, start, j);
            System.out.println(Arrays.toString(dataWraps));
            // 递归左子序列
            subSort(dataWraps, start, j - 1);
            // 递归右子序列
            subSort(dataWraps, j + 1, end);

        }

    }

    public static void swap(DataWrap[] dataWraps, int i, int j) {
        DataWrap temp = dataWraps[j];
        dataWraps[j] = dataWraps[i];
        dataWraps[i] = temp;
    }
}
