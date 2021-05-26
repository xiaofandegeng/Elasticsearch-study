package com.atguigu.linkedlist.singleList;

import com.atguigu.linkedlist.singleList.HeroNode;
import com.atguigu.linkedlist.singleList.SingleLinkedList;

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

        list.update(new HeroNode(4, "西门庆", "大官人"));

        System.out.println("~~~~~~更新数据后，显示链表~~~~~~");
        list.show();

        System.out.println("~~~~~~删除数据后，显示链表~~~~~~");
        //删除第三个节点
        list.del(4);
        list.del(3);
//        list.del(1);
        list.del(2);

        list.show();
        System.out.println("~~~~~~删除数据后，显示链表~~~~~~");
        list.show();

    }
}
