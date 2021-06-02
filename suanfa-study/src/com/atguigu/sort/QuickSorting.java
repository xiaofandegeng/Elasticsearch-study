package com.atguigu.sort;

import java.util.Arrays;

/**
 * <p>DESC: 快速排序算法</p>
 * <p>DATE: 2021/6/2</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class QuickSorting {
    public static void main(String[] args) {

        int[] arr = CommonMethods.getArr(1000000);
        long before = CommonMethods.getTime();
        quickSort(arr, 0, arr.length - 1);
        long after = CommonMethods.getTime();
        System.out.println("排序总共消费：" + (after - before) + " 时间");

//        int[] arr = {5, 7, 1, 9, 3, 4, 6, 2, 8};
//        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
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
            // 如果左侧的值小于中间值，则不交换，只右移坐标
            if (arr[l] < midNum) {
                l += 1;
            }
            // 如果右侧的值大于中间值，则不交换，只左移坐标
            if (arr[r] > midNum) {
                r -= 1;
            }
            // 跳出循环条件
            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 如果左侧的值等于中间值，则r--
            if (arr[l] == midNum) {
                r -= 1;
            }
            // 如果右侧的值等于中间值，则l++
            if (arr[r] == midNum) {
                l += 1;
            }
        }
        // 递归调用，但需要判断l与r的值，避免栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);
        }

    }
}
