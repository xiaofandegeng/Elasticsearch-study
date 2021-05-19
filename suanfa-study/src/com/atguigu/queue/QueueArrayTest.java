package com.atguigu.queue;

import java.util.Scanner;

public class QueueArrayTest {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        char key = ' '; //客户输入信息
        Scanner scanner = new Scanner(System.in);


        boolean loop = true;
        while (loop){
            System.out.println("s[show]:显示队列数据");
            System.out.println("a[add]:添加队列数据");
            System.out.println("g[get]:取出队列数据");
            System.out.println("h[show]:查看头数据");
            System.out.println("e[exit]:退出程序");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int val = scanner.nextInt();
                    queue.addQueue(val);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数据是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.println("队列的头数据是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }

        }
    }
}
