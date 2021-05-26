package com.atguigu.linkedlist.circle;

/**
 * @Description 环形链表测试类
 * @Author lhw
 * @Date 2021/5/26 20:53
 * @Version 1.0
 **/
public class CircleLinkedListTest {
    public static void main(String[] args) {
        CircleLinkedList list = new CircleLinkedList();
        list.addBoy(125);
        list.showBoy();

        list.countBoy(10, 20, 125);
    }
}
