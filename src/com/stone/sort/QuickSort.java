package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;

/**
 * 快速排序
 * 基本思路：
 * 从待排的数据序列中任取一个数据(如第一个数据）作为分界值，所有比它小的数据元素
 * 一律放到左边，所有比它大的数据元素一律放到它的右边。经过这样一趟下来，该序列
 * 形成左右两个子序列，左边序列中数据元素的值都比分界值小，右边序列中数据元素都比
 * 分界值大。
 * 接下来对左、右两个子序列进行递归，对两个子序列重新选择中心元素并依此规则调整，
 * 直到每个子序列的元素只剩下一个，排序完成。
 * <p>
 * 时间效率为O(n*㏒n)
 * 空间效率为O(㏒n)
 * (底数为2)
 * 快速排序是不稳定排序
 * Created by stone on 2017/12/9.
 */
public class QuickSort {

    public static void sort(int[] arr) {
        System.out.println("开始排序");
        subSort(arr, 0, arr.length - 1);
    }

    private static void subSort(int[] arr, int start, int end) {
        // 需要排序
        if (start < end) {
            // 以第一个元素作为分界值
            int base = arr[start];
            // i从左边开始搜索，搜索大于分界值的元素的索引
            int i = start;
            // j从右边开始搜索，搜索小于分界值的元素的索引
            int j = end + 1;
            while (true) {
                // 找到大于分界值的元素的索引，或者i已经到了end处
                while (i < end && arr[++i] < base) ;
                // 找到小于分界值的元素的索引，或者j已经到了start处
                while (j > start && arr[--j] > base) ;
                //
                if (i < j) {
                    // i<j,则交换两个索引处的元素
                    swap(arr, i, j);
                } else {
                    break;
                }
                System.out.println(Arrays.toString(arr));
            }
            // 将分界值和j索引处的元素交换
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
