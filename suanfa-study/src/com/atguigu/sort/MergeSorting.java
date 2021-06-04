package com.atguigu.sort;

import java.util.Arrays;

/**
 * <p>DESC: 归并算法</p>
 * <p>DATE: 2021/6/2</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class MergeSorting {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 9,10,45,65,85,78,95,15,35,45,5,3,4,6, 7, 1, 3, 6, 2};

//        int[] arr = CommonMethods.getArr(1000000);
        int[] temp = new int[arr.length];
//
//        long before = CommonMethods.getTime();
        mergeSort(arr, 0, arr.length - 1, temp);
//        long after = CommonMethods.getTime();
//        System.out.println("排序总共消费：" + (after - before) + " 时间");

        System.out.println("排序后的数组： " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并成一个新数组
     *
     * @param arr   拆分后的数组
     * @param left  左坐标
     * @param mid   中间坐标
     * @param right 右坐标
     * @param temp  临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i += 1;
            } else {
                temp[t] = arr[j];
                j += 1;
            }
            t += 1;
        }
        // 将剩下未加入的数据放到临时数组里面
        while (i <= mid) {
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
