package com.stone.sort;

import com.stone.DataWrap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {
    @Test
    public void testSort4Int() {
        int[] arr = {8, 3, 4, 6, 7, 9, 2, 1, 5};

        System.out.println("排序之前：\n" + Arrays.toString(arr));
        // 开始排序
        BubbleSort.sort(arr);
        System.out.println("排序之后：\n" + Arrays.toString(arr));

        int[] expecteds = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertArrayEquals(expecteds, arr);
    }


    @Test
    public void testSort4DataWrap() {
        DataWrap[] dataWraps = {
                new DataWrap(9, ""),
                new DataWrap(16, ""),
                new DataWrap(21, "*"),
                new DataWrap(23, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(21, ""),
                new DataWrap(30, "*")
        };
        System.out.println("排序之前：\n" + Arrays.toString(dataWraps));
        // 开始排序
        BubbleSort.sort(dataWraps);
        System.out.println("排序之后：\n" + Arrays.toString(dataWraps));

        String expecteds = "[9, 16, 21*, 21, 23, 30, 30*, 49]";
        Assert.assertEquals(expecteds, Arrays.toString(dataWraps));

    }


}
