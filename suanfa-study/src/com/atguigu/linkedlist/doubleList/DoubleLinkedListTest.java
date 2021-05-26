package com.atguigu.linkedlist.doubleList;

/**
 * @Description 双向链表测试类
 * @Author lhw
 * @Date 2021/5/25 21:41
 * @Version 1.0
 **/
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        //初始化英雄
        HeroNode2 hero3 = new HeroNode2(3, "林冲", "豹子头");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero4 = new HeroNode2(4, "武松", "打虎头");
        HeroNode2 hero2 = new HeroNode2(2, "吴用", "智多星");
        //往双向链表里面添加节点
//        list.addHero(hero3);
//        list.addHero(hero1);
//        list.addHero(hero4);
//        list.addHero(hero2);

        //双向链表有序添加节点
        list.addByOrder(hero3);
        list.addByOrder(hero1);
        list.addByOrder(hero4);
        list.addByOrder(hero2);
        //双向链表打印
        list.show();

        HeroNode2 newHero = new HeroNode2(4, "西门庆", "大官人");
        list.update(newHero);
        System.out.println("~~~~~~更新后显示双向链表~~~~~~");
        list.show();

        list.del(2);
        System.out.println("~~~~~~删除节点后显示双向链表~~~~~~");
        list.show();


    }
}
