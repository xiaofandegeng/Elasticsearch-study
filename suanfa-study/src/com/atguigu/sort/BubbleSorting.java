package com.atguigu.sort;

import java.util.Arrays;

/**
 * <p>DESC: 冒泡排序</p>
 * <p>DATE: 2021/6/1</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class BubbleSorting {
    public static void main(String[] args) {
        int[] arr = {-3, -1, 9, 10, -2};

        //  冒泡排序的优化，添加一个符号，如果这次没有移动，则表示排序已结束
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //  进入了排序，至少还需要一次排序
            if (flag) {
                flag = false;
            } else {
                break;
            }

            System.out.println("第" + (i + 1) + "趟排序后的结果为： " + Arrays.toString(arr));
        }
    }
}
