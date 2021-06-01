package com.atguigu.recursion;

/**
 * <p>DESC: 八皇后测试类</p>
 * <p>DATE: 2021/6/1</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class EightQueueTest {
    public static void main(String[] args) {
        EightQueue queue = new EightQueue();
        queue.check(0);
        System.out.println("一共有" + queue.count + "种解法！");
        System.out.println("一共运算了" + queue.countNum + "次！");
    }
}
