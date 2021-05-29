package com.atguigu.stack;

/**
 * @Description stack栈的计算器
 * @Author lhw
 * @Date 2021/5/27 19:43
 * @Version 1.0
 **/
public class Calculator {
    public static void main(String[] args) {
        String expression = "2+6*2-4";
        //  数栈用于存放数字 符号栈用于存放符号
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack oprStack = new ArrayStack(10);
        //  打印变量 index-字符串的下标
    }
}
