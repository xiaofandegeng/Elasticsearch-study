package com.atguigu.linkedlist.doubleList;

/**
 * 双向链表英雄节点 存储英雄排序、名字、别名、后一个英雄节点
 */
public class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    //  指向当前节点的的下一个节点
    public HeroNode2 next;
    //  指向当前节点的前一个节点
    public HeroNode2 pre;

    //英雄构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，重写tostring
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
