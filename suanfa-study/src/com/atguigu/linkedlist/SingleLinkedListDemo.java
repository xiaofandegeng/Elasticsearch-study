package com.atguigu.linkedlist;

/**
 * 单链表面试题
 * 1.求单链表中有效节点的个数
 * 2.查找单链表中的倒数第k个结点 【新浪面试题】
 * 3.单链表的反转【腾讯面试题，有点难度】
 * 4.从尾到头打印单链表 【百度，要求方式1：反向遍历 。 方式2：Stack栈】
 * 5.合并两个有序的单链表，合并之后的链表依然有序【课后练习.】
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        //  初始化英雄
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "吴用", "智多星");
        HeroNode hero3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode hero4 = new HeroNode(4, "武松", "打虎头");

        //  按顺序添加英雄
        list.addByOrder(hero4);
        list.addByOrder(hero1);
        list.addByOrder(hero3);
        list.addByOrder(hero2);

        //  显示链表
        list.show();

        //  获得链表的节点个数
        Integer length = list.getLength();
        System.out.println("当前链表的节点个数是：" + length);

        //  获得倒数第n个节点的信息
        int descNum = 0;
        HeroNode descNode = list.getDescNum(descNum);
        System.out.println("查询到的节点信息为："  + descNode);

        //  反转链表
        list.reverseNode(list.getHeadNode());
        System.out.println("~~~~~~当前链表反转~~~~~~");
        list.show();

        //  从头到尾打印链表
        System.out.println("~~~~~~从尾到头打印链表~~~~~~");
        list.reversePrintNode(list.getHeadNode());

    }
}
