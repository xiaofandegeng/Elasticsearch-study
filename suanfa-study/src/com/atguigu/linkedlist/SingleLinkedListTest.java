package com.atguigu.linkedlist;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        //初始化英雄
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "吴用", "智多星");
        HeroNode hero3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode hero4 = new HeroNode(4, "武松", "打虎头");

//        list.addHero(hero1);
//        list.addHero(hero2);
//        list.addHero(hero3);
//        list.addHero(hero4);
//        list.addHero(hero2);

        list.addByOrder(hero4);
        list.addByOrder(hero1);
        list.addByOrder(hero3);
        list.addByOrder(hero2);
        list.addByOrder(hero2);

        //  显示链表
        list.show();

    }
}
