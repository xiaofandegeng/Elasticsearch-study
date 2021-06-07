package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DESC: 二分查找算法</p>
 * <p>DATE: 2021/6/7</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 66, 66, 66, 66, 66, 444, 444, 666, 888};
        int index = binarySearch(arr, 0, arr.length - 1, 444);
        if (index == -1) {
            System.out.println("没有找到这个值！");
        } else {
            System.out.println("查找到这个值，它的下标为：" + index);
        }
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 444);
        System.out.println(list);
    }

    private static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {

        if (left > right) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal < value) {
            list = binarySearch2(arr, mid + 1, right, value);
        } else if (midVal > value) {
            list = binarySearch2(arr, left, mid - 1, value);
        } else {

            int tempLeft = mid - 1;
            while (tempLeft >= 0 && arr[tempLeft] == value) {
                list.add(tempLeft);
                tempLeft -= 1;
            }
            list.add(mid);
            int tempRight = mid + 1;
            while (tempRight <= arr.length - 1 && arr[tempRight] == value) {
                list.add(tempRight);
                tempRight += 1;
            }

        }
        return list;
    }


    private static int binarySearch(int[] arr, int left, int right, int value) {
        int res = -1;
        if (left <= right) {
            int mid = (left + right) / 2;
            int midVal = arr[mid];
            if (midVal < value) {
                res = binarySearch(arr, mid + 1, right, value);
            } else if (midVal > value) {
                res = binarySearch(arr, left, mid - 1, value);
            } else {
                res = mid;
            }
        }

        return res;
    }
}
