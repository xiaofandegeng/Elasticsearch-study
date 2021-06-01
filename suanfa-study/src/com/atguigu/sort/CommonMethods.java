package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>DESC: 公共方法类</p>
 * <p>DATE: 2021/6/1</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class CommonMethods {
    public static int[] getArr(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        return arr;
    }

    public static void getBeforeTime() {
        Date before = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeDate = simpleDateFormat.format(before);
        System.out.println("排序前的时间为：" + beforeDate);
    }

    public static void getAfterTime() {
        Date after = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String afterDate = simpleDateFormat.format(after);
        System.out.println("排序前的时间为：" + afterDate);
    }
}
