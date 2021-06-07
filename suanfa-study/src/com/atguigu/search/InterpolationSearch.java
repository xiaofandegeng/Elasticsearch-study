package com.atguigu.search;

/**
 * @Description 插值查找算法
 * @Author lhw
 * @Date 2021/6/7 19:52
 * @Version 1.0
 **/
public class InterpolationSearch {
    public static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        int index = interpolationSearch(arr, 0, arr.length - 1, 1);
        if(index == -1){
            System.out.println("没有找到这个值！");
        }else {
            System.out.println("查找到这个值，它的下标为：" + index);
        }
    }

    private static int interpolationSearch(int[] arr, int left, int right, int value) {
        System.out.println("查找了" + (++count) + "次");
        int res = -1;

        // 直接退出
        if (left > right || value < arr[left] || value > arr[right]) {
            return res;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (value < midValue) {
            res = interpolationSearch(arr, left, mid - 1, value);
        } else if (midValue < value) {
            res = interpolationSearch(arr, mid + 1, right, value);
        } else {
            res = mid;
        }


        return res;
    }
}
