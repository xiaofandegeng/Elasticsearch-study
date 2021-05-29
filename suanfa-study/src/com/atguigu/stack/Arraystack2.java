package com.atguigu.stack;

/**
 * <p>DESC: 自定义的栈</p>
 * <p>DATE: 2021/5/28</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class Arraystack2 {
    /**
     * 定义变量 栈的大小 栈的数组 栈底的指针
     */
    private int maxSize;
    private int[] arr;
    private int top = -1;

    /**
     * 构造器 初始化
     *
     * @param maxSize 栈的最大容量
     */
    public Arraystack2(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断栈是否满
     *
     * @return 栈满为true，栈未满未false
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     *
     * @return 栈空为true，栈非空为false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 取出栈顶的数
     *
     * @return 栈顶的值
     */
    public int peek() {
        return arr[top];
    }

    /**
     * 入栈
     *
     * @param num 入栈的值
     */
    public void push(int num) {
        if (isFull()) {
            throw new RuntimeException("当前栈已满，无法再添加元素！");
        }
        top++;
        arr[top] = num;
    }

    /**
     * 出栈
     *
     * @return 出栈的值
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈为空，无法再取出元素！");
        }
        int val = arr[top];
        top--;
        return val;
    }

    /**
     * 循环打印栈里面的元素
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("当前栈已没有数据了，无法再打印！");
            return;
        }
        //  从栈顶开始打印数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("当前值为：arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 返回运算符的优先级，数字越大，优先级越高
     *
     * @param opr 运算符
     * @return 优先级大小
     */
    public int priority(int opr) {
        if (opr == '*' || opr == '/') {
            return 1;
        } else if (opr == '+' || opr == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否运算符
     *
     * @param ch 运算符
     * @return 运算符为true 否则为false
     */
    public boolean isOpr(int ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public int cal(int num1, int num2, int opr) {
        int res = 0;
        switch (opr) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}
