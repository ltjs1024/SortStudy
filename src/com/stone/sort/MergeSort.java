package com.stone.sort;

import com.stone.DataWrap;

/**
 * 归并排序算法
 * 实现思路：
 * 将两个（或以上）有序的序列合并成一个新的有序序列。
 * 此处主要是将两个有序的数据序列合并成一个新的有序序列。
 * 具体来说，先将长度为n的无序序列看成是n个长度为1的有序序列，首先做两丙合并，
 * 得到n/2个长度为2的有序子序列，再做两两合并。。。。。不断地重复这个过程，最终
 * 可得到一个长度为n的有序序列。
 * <p>
 * 时间复杂度：O(nlogn)   底为2
 * 空间复杂度：需要一个与原始序列同样大小的辅助序列
 * 归并排序算法是稳定的
 * <p>
 * * Created by stone on 2017/12/14.
 */
public class MergeSort {


    public static void sort(int[] data) {
        System.out.println("开始排序");
        sort(data, 0, data.length - 1);
    }

    /**
     * 将索引从left到right范围的数组元素进行归并排序
     *
     * @param data  待排序的数组
     * @param left  待排序的数组的第一个元素索引
     * @param right 待排序的数组的最后一个元素的索引
     */
    private static void sort(int[] data, int left, int right) {
        if (left < right) {
            // 找出中间索引
            int center = (left + right) / 2;
            // 对左边数组进行递归
            sort(data, left, center);
            // 对左边数组进行递归
            sort(data, center + 1, right);
            // 合并
            merge(data, left, center, right);
        }
    }

    /**
     * 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
     *
     * @param data   数组对象
     * @param left   左数组的第一个元素的索引
     * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素
     * @param right  右数组的最后一个元素的索引
     */
    private static void merge(int[] data, int left, int center, int right) {
        int[] tempArr = new int[data.length];

        int mid = center + 1;
        // third记录中间数组的索引
        int third = left;
        int temp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出小的放入中间数组
            if (data[left] <= data[mid]) {
                tempArr[third++] = data[left++];
            } else {
                tempArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入中间数组
        while (mid <= right) {
            tempArr[third++] = data[mid++];
        }
        while (left <= center) {
            tempArr[third++] = data[left++];
        }
        // 将中间数组中的内容复制拷回原数组
        //（原left--right范围的内容被复制回原数组）
        while (temp <= right) {
            data[temp] = tempArr[temp++];
        }
    }

    public static void sort(DataWrap[] dataWraps) {

    }
}
