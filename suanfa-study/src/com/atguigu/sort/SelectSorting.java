package com.atguigu.sort;

import java.util.Arrays;

/**
 * <p>DESC: 选择排序算法</p>
 * <p>DATE: 2021/6/1</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class SelectSorting {
    public static void main(String[] args) {
//        int[] arr = CommonMethods.getArr(800000);
//
//        long before = CommonMethods.getTime();
//        selectSorting(arr);
//        long after = CommonMethods.getTime();
//        System.out.println("排序总共消费：" + (after - before) + " 时间");

        int[] arr = {9, 4, 7, 6, 2, 1, 4, 5, 6, 3, 8, 4, 5, 3, 1, 8, 9, 7, 5, 1};
        selectSorting(arr);
    }

    /**
     * 选择排序
     *
     * @param arr 需要排序的数组
     */
    private static void selectSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            // j永远在i的右边
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[minIndex];
                }
            }
            // 避免第一个值就是最小值的情况
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
