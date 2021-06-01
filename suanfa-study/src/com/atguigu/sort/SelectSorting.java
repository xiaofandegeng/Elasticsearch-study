package com.atguigu.sort;

/**
 * <p>DESC: 选择排序算法</p>
 * <p>DATE: 2021/6/1</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class SelectSorting {
    public static void main(String[] args) {
        int[] arr = CommonMethods.getArr(80000);

        CommonMethods.getBeforeTime();
        selectSorting(arr);
        CommonMethods.getAfterTime();
    }

    /**
     * 选择排序
     *
     * @param arr 需要排序的数组
     */
    private static void selectSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[minIndex];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

        //System.out.println("排序后：" + Arrays.toString(arr));
    }
}
