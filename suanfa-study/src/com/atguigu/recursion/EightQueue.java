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
     * 判断是否成功放置
     *
     * @param n 起始行数
     */
    public void check(int n) {
        //  如果来到了第九行，则表示已经成功一次
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //  当前行的皇后从0列的位置开始
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    /**
     * 判断当前皇后能否放置成功，成功为true，失败为false
     *
     * @param n 当前行数
     * @return 能否防止
     */
    public boolean judge(int n) {
        //  记录进来判断了多少次
        countNum++;
        //  与之前的列比较，如果不在同一列，同一条斜线（斜线用等腰三角形，斜率为1判断），则允许放置
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印每一种成功的结果，并记录成功了多少次
     */
    public void print() {
        count++;
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
