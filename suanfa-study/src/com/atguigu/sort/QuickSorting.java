package com.atguigu.sort;

import java.util.Arrays;

/**
 * <p>DESC: 快速排序算法</p>
 * <p>DATE: 2021/6/2</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class QuickSorting {
    private static int count = 0;

    public static void main(String[] args) {

//        int[] arr = CommonMethods.getArr(1000000);
//        long before = CommonMethods.getTime();
//        quickSort(arr, 0, arr.length - 1);
//        long after = CommonMethods.getTime();
//        System.out.println("排序总共消费：" + (after - before) + " 时间");

        int[] arr = {5, 7, 9, 8, 7, 5, 6, 5, 1, 5, 3, 4, 6, 2, 8};
        quickSort(arr, 0, arr.length - 1);
//        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }

    /**
     * 快速排序
     *
     * @param arr   需要排序的数组
     * @param left  起始坐标
     * @param right 终点坐标
     */
    private static void quickSort(int[] arr, int left, int right) {
        // 起始坐标l,r，中间位置的值minNum
        int l = left;
        int r = right;
        int midNum = arr[(l + r) / 2];
        int temp;
        // 循环
        while (l < r) {
            // 找到比中间数值大的左侧坐标
            while (arr[l] < midNum) {
                l += 1;
            }
            // 找到比中间数值小的右侧坐标
            while (arr[r] > midNum) {
                r -= 1;
            }
            // 循环中止条件
            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果左侧的值等于中间值，左移r
            if (arr[l] == midNum) {
                r -= 1;
            }
            // 如果右侧的值等于中间值，右移l
            if (arr[r] == midNum) {
                l += 1;
            }
        }
        // 避免栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 再次快排
        if (l < right) {
            quickSort(arr, l, right);
        }
        if (left < r) {
            quickSort(arr, left, r);
        }

//        System.out.println("第" + (++count) + "次排序后的数组：" + Arrays.toString(arr));
    }
}
