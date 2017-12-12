package com.stone.sort;

import com.stone.DataWrap;

import java.util.Arrays;

/**
 * 折半插入排序
 * 思路：
 * <p>
 * 是对直接插入排序的简单改进：不会直接从i-1个元素开始逐个比较每个元素。
 * (1).计算0 ～ i-1索引的中间点，也就是用i索引处的元素和(0+i-1)/2索引处的元素进行比较，
 * 如果i索引处的元素大，就直接在(0+i-1)/2 ～ i-1 半个范围内搜索；
 * 反之，就在0 ～ (0+i-1)/2 半个范围内搜索，这就是所谓的折半。
 * (2).在半个范围内搜索时，再按(1)步方法进行折半搜索。总是不断地折半，这样就可以将搜索范围
 * 缩小到1/2、1/4、1/8，从而快速确定第i元素的插入位置。
 * (3).一旦确定了第i个元素的插入位置。程序将该位置以后的元素整体后移一位，
 * 然后将第i个元素放入该位置。
 * <p>
 * Created by stone on 2017/12/12.
 */
public class BinaryInsertSort {

    public static void sort(int[] data) {
        System.out.println("开始排序");
        for (int i = 1; i < data.length; i++) {
            // 当整体后移时，保证data[i]的值不会丢失
            int temp = data[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                // 找出low、high中间的索引
                int mid = (low + high) / 2;
                // 如果temp值大于low、high中间元素的值
                if (temp > data[mid]) {
                    // 限制在索引大于mid的那一半中搜索
                    low = mid + 1;
                } else {
                    // 限制在索引小于mid的那一半中搜索
                    high = mid - 1;
                }
            }
            // 将low到i处的所有元素向后整体移一位
            for (int j = i; j > low; j--) {
                data[j] = data[j - 1];
            }
            // 最后将temp的值插入合适位置
            data[low] = temp;

            System.out.println(Arrays.toString(data));
        }


    }

    public static void sort(DataWrap[] data) {
        System.out.println("开始排序");
        for (int i = 1; i < data.length; i++) {
            DataWrap temp = data[i];
            int low = 0;
            int high = i - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp.compareTo(data[mid]) > 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            for (int j = i; j > low; j--) {
                data[j] = data[j - 1];
            }
            data[low] = temp;
            System.out.println(Arrays.toString(data));
        }
    }
}
