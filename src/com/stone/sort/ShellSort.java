package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;

/**
 * Shell排序
 * 实现思路：
 * <p>
 * <p>
 * 时间效率：O(N3/2)--O(N7/6)
 * 空间效率：O(1)
 * Shell排序是稳定的
 */
public class ShellSort {


    public static void sort(int[] data) {
        System.out.println("开始排序");
        // h变量保存可变增量
        int h = 1;
        // 按h*3+1得到增量序列的最大值
        while (h <= data.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.println("====h的值：" + h + "====");
            for (int i = h; i < data.length; i++) {
                // 当整体后移时，保存dataWraps[i]的值不会丢失
                int temp = data[i];
                // i索引处的值已经比前面所有值都大，表明已经有序，无需插入
                // (i-1索引之前的数据已经有序的，i-1索引处元素的值就是最大值）
                if (data[i] < data[i - h]) {
                    int j = i - h;
                    // 整体后移h格
                    for (; j >= 0 && data[j] > temp; j -= h) {
                        data[j + h] = data[j];
                    }
                    // 最后将temp的值插入合适位置
                    data[j + h] = temp;
                }
                System.out.println(Arrays.toString(data));
            }
            h = (h - 1) / 3;
        }

    }

    public static void sort(DataWrap[] dataWraps) {
        System.out.println("开始排序");
        // h变量保存可变增量
        int h = 1;
        // 按h*3+1得到增量序列的最大值
        while (h <= dataWraps.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.println("====h的值：" + h + "====");
            for (int i = h; i < dataWraps.length; i++) {
                // 当整体后移时，保存dataWraps[i]的值不会丢失
                DataWrap temp = dataWraps[i];
                // i索引处的值已经比前面所有值都大，表明已经有序，无需插入
                // (i-1索引之前的数据已经有序的，i-1索引处元素的值就是最大值）
                if (dataWraps[i].compareTo(dataWraps[i - h]) < 0) {
                    int j = i - h;
                    // 整体后移h格
                    for (; j >= 0 && dataWraps[j].compareTo(temp) > 0; j -= h) {
                        dataWraps[j + h] = dataWraps[j];
                    }
                    // 最后将temp的值插入合适位置
                    dataWraps[j + h] = temp;
                }
                System.out.println(Arrays.toString(dataWraps));
            }
            h = (h - 1) / 3;
        }
    }

}
