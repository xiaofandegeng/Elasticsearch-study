package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>DESC: 冒泡排序</p>
 * <p>DATE: 2021/6/1</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class BubbleSorting {
    public static void main(String[] args) {
        int[] arr = CommonMethods.getArr(80000);

        long before = CommonMethods.getTime();
        bubbleSorting(arr);
        long after = CommonMethods.getTime();
        System.out.println("排序总共消费：" + (after - before) + " 时间");
    }

    /**
     * 冒泡排序的方法
     *
     * @param arr 输入数组
     */
    private static void bubbleSorting(int[] arr) {
        //  冒泡排序的优化，添加一个符号，如果这次没有移动，则表示排序已结束
        boolean flag = false;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
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

//            System.out.println("第" + (i + 1) + "趟排序后的结果为： " + Arrays.toString(arr));
        }
    }
}
