package com.atguigu.stack;

/**
 * <p>DESC: 计算器</p>
 * <p>DATE: 2021/5/28</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: lhw</p>
 */
public class Calculator {
    public static void main(String[] args) {
        /**
         * 定义两个栈 一个数栈 一个操作栈
         */
        Arraystack2 numStack = new Arraystack2(10);
        Arraystack2 oprStack = new Arraystack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int opr = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

        String str = "2+6*2-4";
        while (true) {
            ch = str.charAt(index);
            //  判断ch是操作符还是数字，做出对应的处理
            if (oprStack.isOpr(ch)) {
                //  判断当前符号栈是否有操作符，如果没有，直接入栈，否则做相应的处理
                if (!oprStack.isEmpty()) {
                    //  当前符号栈有操作符，如果当前操作符的优先级小于或等于栈中的操作符
                    //  则从符号栈中取出一个符合进行计算，将得到的结果入数栈，然后将当前符合入符号栈
                    if (oprStack.priority(ch) <= oprStack.priority(oprStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opr = oprStack.pop();
                        res = numStack.cal(num1, num2, opr);
                        //  将运算结果入数栈
                        numStack.push(res);
                    }
                    oprStack.push(ch);
                } else {
                    oprStack.push(ch);
                }
            } else {
                keepNum += ch;
                //  判断是否到了最后
                if (index == str.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (oprStack.isOpr(str.charAt(index + 1))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            //  终止循环
            if (index >= str.length()) {
                break;
            }
        }
        //  当扫描完毕，按序取出计算
        while (true) {
            if (oprStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            opr = oprStack.pop();
            res = numStack.cal(num1, num2, opr);
            numStack.push(res);

        }
        System.out.println("最后的结果为：" + numStack.pop());
    }
}
