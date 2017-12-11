package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;

/**
 * 直接插入排序
 * 思路：
 * <p>
 * 依次将待排序的数据元素按其关键字值的大小插入前面的有序序列。
 * 对于一个有n个元素数据序列，排序需要进行n-1趟插入操作。
 * 第1趟插入：将第2个元素插入前面的有序子序列--此时前面只有一个元素，当然是有序的。
 * 第2趟插入：将第3个元素插入前面的有序子序列，前面2个元素是有序的。
 * 。。。。。。
 * 第n-1趟插入：将第n个元素插入前面的有序子序列，前面n-1个元素是有序的。
 * <p>
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 插入排序是稳定的
 * <p>
 * Created by stone on 2017/12/11.
 */
public class InsertSort {

    public static void sort(int[] arr) {
        System.out.println("开始排序");
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                // 数据
                for (; j >= 0 && arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }


    }

    public static void sort(DataWrap[] dataWraps) {
        System.out.println("开始排序");
        for (int i = 1; i < dataWraps.length; i++) {

            DataWrap temp = dataWraps[i];

            if (dataWraps[i].compareTo(dataWraps[i - 1]) < 0) {
                int j = i - 1;
                for (; j >= 0 && dataWraps[j].compareTo(temp) > 0; j--) {
                    dataWraps[j + 1] = dataWraps[j];
                }
                dataWraps[j + 1] = temp;
            }
            System.out.println(Arrays.toString(dataWraps));
        }
    }
}
