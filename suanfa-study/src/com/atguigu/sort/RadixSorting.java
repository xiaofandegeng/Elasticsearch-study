package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Description 基数排序算法
 * @Author lhw
 * @Date 2021/6/3 21:30
 * @Version 1.0
 **/
public class RadixSorting {

    public static void main(String[] args) {
//        int[] arr = {41, 45, 35, 14, 85, 75, 111, 134, 41, 191, 851, 457, 4, 7, 4, 5};
//        radixSort(arr);

//        System.out.println("排序后数组为：" + Arrays.toString(arr));



        int[] arr = CommonMethods.getArr(10000000);

        long before = CommonMethods.getTime();
        radixSort(arr);
        long after = CommonMethods.getTime();
        System.out.println("排序总共消费：" + (after - before) + " 时间");
    }

    private static void radixSort(int[] arr) {
        // 找出最大值的长度，好计算循环多少次
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = String.valueOf(max).length();

        // 定义一个二维数组，x轴表示求余的范围（0-9），所以空间大小为10，y表示求出的余数的个数，用一个空间为10的一维数组表示，一维数组对应了x轴的下标位置。
        int[][] bucket = new int[10][arr.length];

        int[] bucketElementCount = new int[10];
        // 开始循环 i表示循环次数（有最大值的位数决定） n表示10的次方（求余使用）
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                int digitElement = value / n % 10;
                bucket[digitElement][bucketElementCount[digitElement]] = value;
                bucketElementCount[digitElement] += 1;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCount[k] = 0;
            }
        }
    }
}
