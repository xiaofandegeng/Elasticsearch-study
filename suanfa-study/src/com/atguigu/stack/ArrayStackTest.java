package com.atguigu.stack;

import javax.sound.midi.Soundbank;

/**
 * @Description 数组栈测试类
 * @Author lhw
 * @Date 2021/5/26 22:23
 * @Version 1.0
 **/
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);

        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(20);

        stack.list();
        Integer pop = stack.pop();
        System.out.println(pop);
    }
}
