package com.atguigu.recursion;

/**
 * <p>DESC: 八皇后回溯法</p>
 * <p>DATE: 2021/6/1</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class EightQueue {
    int max = 8;
    int[] arr = new int[max];
    int count = 0;
    int countNum = 0;

    /**
     * 回溯算法
     *
     * @param n 当前行数
     */
    public void check(int n) {
        //  如果行数来到了第九行，运算结束
        if (n == max) {
            print();
            return;
        }
        //  循环去判断，成功则去下一行，否则
        for (int i = 0; i < max; i++) {
            //  先将当前皇后放置第一列，然后依次后移
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    /**
     * 判断目前这行什么位置能够放置皇后
     *
     * @param n 当前行数
     * @return 成功表示能够放置皇后
     */
    public boolean judge(int n) {
        //  记录回溯算法执行了多少次
        countNum++;
        //  当前皇后不能与之前的皇后在同一行和斜行上（斜行用等腰直角三角形的两条边来表示，也就是斜率为1）
        for (int i = 0; i < n; i++) {
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印每一种结果
     */
    public void print() {
        //  记录一共有多少中解法
        count++;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
