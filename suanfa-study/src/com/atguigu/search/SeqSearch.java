package com.atguigu.search;

/**
 * <p>DESC: 线性查找</p>
 * <p>DATE: 2021/6/7</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,5,7,9,3};
        int index = seqSearch(arr, 9);
        if(index == -1){
            System.out.println("没有找到这个值！");
        }else {
            System.out.println("查找到这个值，它的下标为：" + index);
        }
    }

    private static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
