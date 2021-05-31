package com.atguigu.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <p>DESC: 逆波兰计算器</p>
 * <p>DATE: 2021/5/31</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class PolandNotation {
    public static void main(String[] args) {
        //  先定义逆波兰表达式 (3+4)*5-6 =>  3 4 + 5 * 6 - (结果是29)
        String str = "3 4 + 5 * 6 -";
        List<String> list = getList(str);
        System.out.println(list);
        int res = cal(list);
        System.out.println("计算结果为： " + res);
    }

    /**
     * 计算器
     *
     * @param list 分割好的list集合
     * @return 计算结果res
     */
    private static int cal(List<String> list) {
        int res;
        Stack<String> stack = new Stack<>();
        //  循环这个list，如果是数字放入栈中，如果是计算符取出计算
        for (String el : list) {
            //  el是数字
            if (el.matches("\\d+")) {
                stack.add(el);
            }
            //  el是符号
            else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (el) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("传入的运算符有误会，请修改");
                }
                stack.push(String.valueOf(res));
            }
        }
        res = Integer.parseInt(stack.pop());
        return res;
    }

    /**
     * 将字符串转化为list集合
     *
     * @param str 字符串
     * @return list集合
     */
    public static List<String> getList(String str) {
        List<String> list = new ArrayList<>();
        String[] s = str.split(" ");
        Collections.addAll(list, s);
        return list;
    }

}
