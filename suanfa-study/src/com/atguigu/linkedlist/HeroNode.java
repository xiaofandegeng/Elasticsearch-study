package com.atguigu.linkedlist;

/**
 * 英雄节点 存储英雄排序、名字、别名、后一个英雄节点
 */
public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    //英雄构造器
    public HeroNode(int no, String name, String nickname) {
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
