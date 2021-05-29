package com.atguigu.stack;

/**
 * @Description 数组栈
 * @Author lhw
 * @Date 2021/5/26 22:11
 * @Version 1.0
 **/
public class ArrayStack {
    private final int maxSize;
    private final int[] stack;
    public int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("当前栈已满，无法添加数据~~~~~~");
            return;
        }
        this.top++;
        stack[top] = val;
    }

    public Integer pop() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈已空，无法取出数据~~~~~~");
        }
        int val = stack[top];
        top--;
        return val;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈已空，无法取出数据~~~~~~");
        }
        while (true) {
            if (top == -1) {
                break;
            }
            System.out.printf("当前数据为：stack[%d] = %d \n", top, stack[top]);
            top--;
        }
    }

    public boolean isOpr(int ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public Integer peek() {
        return stack[top];
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
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
