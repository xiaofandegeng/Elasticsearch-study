package com.atguigu.search;

import java.util.Arrays;

/**
 * @Description 斐波那契查找算法
 * @Author lhw
 * @Date 2021/6/7 20:49
 * @Version 1.0
 **/
public class FibonacciSearch {
    public static int max = 20;

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 44, 66, 222};
        int index = fibonacciSearch(arr, 222);
        if (index == -1) {
            System.out.println("没有找到这个值！");
        } else {
            System.out.println("查找到这个值，它的下标为：" + index);
        }
    }


    private static int fibonacciSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; // 斐波那契的下标
        int mid;
        int[] f = f();

        while (high > f[k] - 1) {
            k++;
        }

        int[] temp = Arrays.copyOf(arr, f[k]);

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k -1] - 1;
            if(value < temp[mid]){
                high = mid - 1;
                k -= 1;
            }else if(value > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if(mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }

        return -1;
    }

    /**
     * @return 返回一个斐波那契的数组
     */
    public static int[] f() {
        int[] res = new int[max];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res;
    }
}
