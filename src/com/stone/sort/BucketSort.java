package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;

/**
 * 桶式排序
 * 需要待排序列满足如下两个特征：
 * 1.待排序列的所有值处于一个可枚举范围内；
 * 2.待排序列所在的这个可枚举范围不应该太大，否则排序开销太大。
 * <p>
 * 思路：
 * 1，对于这个可枚举范围构建一个buckets数组，用于记录“落入”每个桶中的元素的个数；
 * 2，重新计算buckets数组的元素：
 * buckets[i]=buckets[i]+buckets[i-1];(其中1<=i<buckets.length)
 * <p>
 * <p>
 * 时间效率极高，只要经过2轮遍历
 * 空间开销较大，它需要两个数组：
 * 桶式排序是稳定的。
 * Created by stone on 2017/12/16.
 */
public class BucketSort {

    public static void sort(int[] data, int min, int max) {
        System.out.println("开始排序");
        // 待排序 数组的长度
        int arrayLength = data.length;
        int[] temp = new int[arrayLength];
        // buckets数组相当于定义了max-min个桶
        // buckets数组用于记录待排序元素的信息
        int[] buckets = new int[max - min];
        // 计算每个元素在序列出现的次数
        for (int i = 0; i < arrayLength; i++) {
            buckets[data[i] - min]++;
        }
        System.out.println(Arrays.toString(buckets));
        // 重新计算“落入”各桶内的元素在有序序列中的位置
        for (int i = 1; i < max - min; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }
        System.out.println(Arrays.toString(buckets));
        // 将data数组中数据完全复制到temp数组中缓存起来
        System.arraycopy(data, 0, temp, 0, arrayLength);
        //根据buckets数组中的信息将待排序列的各元素放入相应的位置
        for (int k = arrayLength - 1; k >= 0; k--) {
            data[--buckets[temp[k] - min]] = temp[k];
        }

    }

    public static void sort(DataWrap[] data, int min, int max) {
        System.out.println("开始排序");


    }
}
