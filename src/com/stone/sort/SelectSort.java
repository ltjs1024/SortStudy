package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;


/**
 * 直接选择排序
 * <p>
 * 实现思路：
 * 1、第1趟比较：程序将记录定位在第1个数据上，拿第1个数据依次和它后面每个
 * 数据进行比较，如果第1个数据大于后面某个数据，交换它们......依此类推。
 * 经过第1趟比较，这组数据中最小的数据被选出，它被排在第1位。
 * 2、第2趟比较：程序将记录定位在第2个数据上，拿第2个数据依次和它后面每个
 * 数据进行比较，如果第21个数据大于后面某个数据，交换它们......依此类推。
 * 经过第2趟比较，这组数据中第2小的数据被选出，它被排在第2位。
 * 。。。。。。
 * 按此规则一共进行n-1趟比较，这组数据中第n-1小（第2大）的数据被选出，被
 * 排在第n-1位(倒数第1位）；剩下的就是最大的数据，它排在最后。
 * <p>
 * 时间效率为O(n^2)
 * 空间效率为O(1)
 * 直接选择排序是不稳定的
 * <p>
 * 优点：算法简单，容易实现。
 * 缺点：第趟只能确定一个元素，n个元素需要进行n-1趟比较。
 */
public class SelectSort {

    public static void sort(int[] arr) {
        System.out.println("开始排序：");
        // 依次进行n-1趟比较，第i趟比较将第i大的值选出放在i位置上
        for (int i = 0; i < arr.length - 1; i++) {
            // 第i个数据只需和它后面的数据比较
            for (int j = i + 1; j < arr.length; j++) {
                // 如果第i位置的数据>j位置的数据，交换它们。
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

    /**
     * 直接选择排序的优化
     * 在每趟比较过程中，只需要记录本趟比较中最小值的索引，在本趟比较结果后
     * 最多交换一次数据。
     *
     * @param dataWraps
     */
    public static void sort2(DataWrap[] dataWraps) {
        System.out.println("开始排序：");
        int lenth = dataWraps.length;
        for (int i = 0; i < lenth - 1; i++) {
            // minIndex永远保留本趟比较中最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < lenth; j++) {
                // 如果第minIndex位置的数据>j位置的数据
                if (dataWraps[minIndex].compareTo(dataWraps[j]) > 0) {
                    // 将j的值赋给minIndex
                    minIndex = j;
                }
            }
            // 每趟比较最多交换一次
            if (minIndex != i) {
                DataWrap temp = dataWraps[i];
                dataWraps[i] = dataWraps[minIndex];
                dataWraps[minIndex] = temp;
            }
            System.out.println(Arrays.toString(dataWraps));
        }
    }
}
