package com.atguigu.sort;

import java.util.Arrays;

/**
 * <p>DESC: 插入排序算法</p>
 * <p>DATE: 2021/6/1</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class InsertionSorting {
    public static void main(String[] args) {
        int[] arr = CommonMethods.getArr(800000);

        long before = CommonMethods.getTime();
        insertSorting(arr);
        long after = CommonMethods.getTime();
        System.out.println("排序总共消费：" + (after - before) + " 时间");

    }

    /**
     * 插入排序算法
     *
     * @param arr 插入的数组
     */
    private static void insertSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insetValue = arr[i];
            int insertIndex = i - 1;
            //  保证insertIndex 不越界
            while (insertIndex >= 0 && insetValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insetValue;
            }


            //System.out.println("第" + i + "次排序后的结果为： " + Arrays.toString(arr));
        }
    }

    /**
     * 过程分析代码
     *
     * @param arr 传入数组
     */
    private static void guochengfenxi(int[] arr) {
        int insetValue = arr[1];
        int inserIndex = 1 - 1;
        //  保证insertIndex 不越界
        while (inserIndex >= 0 && insetValue < arr[inserIndex]) {
            arr[inserIndex + 1] = arr[inserIndex];
            inserIndex--;
        }
        arr[inserIndex + 1] = insetValue;

        System.out.println("第一次排序后的结果为： " + Arrays.toString(arr));

        insetValue = arr[2];
        inserIndex = 2 - 1;
        //  保证insertIndex 不越界
        while (inserIndex >= 0 && insetValue < arr[inserIndex]) {
            arr[inserIndex + 1] = arr[inserIndex];
            inserIndex--;
        }
        arr[inserIndex + 1] = insetValue;

        System.out.println("第二次排序后的结果为： " + Arrays.toString(arr));

        insetValue = arr[3];
        inserIndex = 3 - 1;
        //  保证insertIndex 不越界
        while (inserIndex >= 0 && insetValue < arr[inserIndex]) {
            arr[inserIndex + 1] = arr[inserIndex];
            inserIndex--;
        }
        arr[inserIndex + 1] = insetValue;

        System.out.println("第三次排序后的结果为： " + Arrays.toString(arr));
    }
}
