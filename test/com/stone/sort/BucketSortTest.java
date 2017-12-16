package com.stone.sort;

import com.stone.DataWrap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BucketSortTest {
    @Test
    public void testSort4Int() {
        int[] arr = {8, 3, 4, 6, 7, 9, 2, 1, 5};

        System.out.println("排序之前：\n" + Arrays.toString(arr));
        // 开始排序
        BucketSort.sort(arr, 1, 10);
        System.out.println("排序之后：\n" + Arrays.toString(arr));

        int[] expecteds = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertArrayEquals(expecteds, arr);
    }


    @Test
    public void testSort4DataWrap() {
        DataWrap[] dataWraps = {
                new DataWrap(9, ""),
                new DataWrap(5, ""),
                new DataWrap(-1, ""),
                new DataWrap(8, ""),
                new DataWrap(5, "*"),
                new DataWrap(7, ""),
                new DataWrap(3, ""),
                new DataWrap(-3, ""),
                new DataWrap(1, ""),
                new DataWrap(3, "*")
        };
        System.out.println("排序之前：\n" + Arrays.toString(dataWraps));
        // 开始排序
        BucketSort.sort(dataWraps, -3, 10);
        System.out.println("排序之后：\n" + Arrays.toString(dataWraps));

        String expecteds = "[-3, -1, 1, 3, 3*, 5, 5*, 7, 8, 9]";
        Assert.assertEquals(expecteds, Arrays.toString(dataWraps));

    }


}
