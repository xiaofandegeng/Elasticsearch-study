package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Description 希尔排序算法
 * @Author lhw
 * @Date 2021/6/1 21:09
 * @Version 1.0
 **/
public class ShellSorting {
    private static final int TWO = 2;

    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = CommonMethods.getArr(10000);

        long before = CommonMethods.getTime();
        // 希尔排序交换法
        shellSortMove(arr);
        long after = CommonMethods.getTime();
        System.out.println("希尔排序总共使用了：" + (after - before) + " 时间");
    }

    /**
     * 交换法的希尔排序
     *
     * @param arr 排序的数组
     */
    private static void shellSortChange(int[] arr) {
        // 1.第一次交换
        int temp;

        for (int gap = arr.length / TWO; gap > 0; gap /= TWO) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("第一次希尔排序后的结果为：" + Arrays.toString(arr));
        }


//        for (int i = 5; i < arr.length; i++) {
//            for (int j = i - 5; j >= 0; j -= 5) {
//                if (arr[j] > arr[j + 5]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//        System.out.println("第一次希尔排序后的结果为：" + Arrays.toString(arr));
//
//        // 1.第二次交换
//        for (int i = 2; i < arr.length; i++) {
//            for (int j = i - 2; j >= 0; j -= 2) {
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println("第二次希尔排序后的结果为：" + Arrays.toString(arr));
//
//        // 1.第三次交换
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i - 1; j >= 0; j -= 1) {
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println("第三次希尔排序后的结果为：" + Arrays.toString(arr));
    }

    /**
     * 希尔排序移动法
     *
     * @param arr 排序的数组
     */
    private static void shellSortMove(int[] arr) {
        int count = 0;
        for (int gap = arr.length / TWO; gap > 0; gap /= TWO) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
            count++;
            System.out.println("第" + count + "次希尔排序后的结果为：" + Arrays.toString(arr));
        }
    }
}
