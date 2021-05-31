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

        String str1 = "11+((2+3)*5)-6";
        List<String> inFixList = toInFix(str1);
        //  结果为[11, +, (, (, 2, +, 3, ), *, 5, ), -, 6]
        //  后缀表达式为 11 2 3 + 5 * + 6 -
        System.out.println(inFixList);
        List<String> sufFixList = sufFix(inFixList);
        System.out.println(sufFixList);
    }

    /**
     * 中缀列表 转换为 后缀列表
     *
     * @param inFixList 中缀列表
     * @return 后缀列表
     */
    private static List<String> sufFix(List<String> inFixList) {
        Stack<String> stack = new Stack<>();
        List<String> resList = new ArrayList<>();
        for (String item : inFixList) {
            //1.初始化两个栈：运算符栈s1和储存中间结果的栈s2；
            //2.从左至右扫描中缀表达式；
            //3.遇到操作数时，将其压s2；
            //4.遇到运算符时，比较其与s1栈顶运算符的优先级：
            //　（1）如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
            //　（2）否则，若优先级比栈顶运算符的高，也将运算符压入s1；
            //　（3）否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
            //5.遇到括号时：　（1）如果是左括号"("，则直接压入s1　（2）如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃6.重复步骤2至5，直到表达式的最右边
            //7.将s1中剩余的运算符依次弹出并压入s2
            //8.依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
            if ("(".equals(item)) {
                stack.add(item);
            } else if (")".equals(item)) {
                while (!"(".equals(stack.peek())) {
                    resList.add(stack.pop());
                }
                stack.pop();
            } else if (item.matches("\\d+")) {
                resList.add(item);
            } else {
                while (!stack.isEmpty() && getPri(item) <= getPri(stack.peek())){
                    resList.add(stack.pop());
                }
                stack.add(item);
            }
        }

        return resList;
    }

    /**
     * 比较两个符号的优先级
     *
     * @param peek 运算符
     * @return 运算符的大小
     */
    private static Integer getPri(String peek) {
        int res = 0;
        if ("+".equals(peek) || "-".equals(peek)) {
            res = 1;
        }
        if ("*".equals(peek) || "\\".equals(peek)) {
            res = 2;
        }
        return res;
    }

    /**
     * 将字符串转换为list
     *
     * @param str1 字符串
     * @return list集合
     */
    private static List<String> toInFix(String str1) {
        List<String> list = new ArrayList<>();
        char[] chars = str1.toCharArray();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            //  如果ch不是数字，直接放入list
            if (chars[i] >= 48 && chars[i] <= 57) {
                while (flag) {
                    if (String.valueOf(chars[i]).matches("\\d+") && i != chars.length - 1) {
                        str.append(chars[i]);
                        i = i + 1;
                    } else {
                        if (i == chars.length - 1) {
                            list.add(String.valueOf(chars[i]));
                        } else {
                            i = i - 1;
                        }
                        flag = false;
                    }
                }
                if (!"".equals(str.toString().trim())) {
                    list.add(str.toString());
                }
            } else {
                list.add(String.valueOf(chars[i]));
            }
            str = new StringBuilder();
        }
        return list;
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
