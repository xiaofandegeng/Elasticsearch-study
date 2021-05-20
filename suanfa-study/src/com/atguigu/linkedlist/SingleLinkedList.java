package com.atguigu.linkedlist;

/**
 * 定义一个类 管理英雄节点
 */
public class SingleLinkedList {
    // 初始化一个头节点
    HeroNode headNode = new HeroNode(0, "", "");

    // 添加新英雄,可以不按编号添加
    public void addHero(HeroNode newHeroNode){
        // 定义一个指针
        HeroNode temp = headNode;
        // 循环这个链表，找到尾节点添加新节点
        while (true){
            // 判断是否是尾节点（下一个节点的数据为null），将新节点添加后该节点的next
            if(temp.next == null) {
                break;
            }
            // 后移指针
            temp = temp.next;
        }
        temp.next = newHeroNode;
    }

    //添加新英雄，按照编号排序
    public void addByOrder(HeroNode newHeroNode){
        //定义一个指针节点
        HeroNode temp = headNode;
        //定义一个变量，判断之前链表相同编号的节点是否存在，默认不存在（false）
        boolean flag = false;
        //循环这个链表，判断能否添加
        while (true){
            // 找到了尾节点直接跳出，添加到末尾
            if(temp.next == null){
                break;
            }
            //找到了插入节点的位置
            if(temp.next.no > newHeroNode.no){
                break;
            }else if(temp.next.no == newHeroNode.no){
                flag = true;
                break;
            }
            //后移指针节点
            temp = temp.next;
        }
        if(flag){
            System.out.printf("当前英雄编号: %d 已存在，不能重复添加\n", newHeroNode.no);
        }else {
            newHeroNode.next = temp.next;
            temp.next = newHeroNode;
        }
    }

    // 显示整个链表
    public void show() {
        // 定义一个指针
        HeroNode temp = headNode;
        // 判断数组是否为空
        if(headNode.next == null){
            System.out.println("~~~~~~当前链表为空~~~~~~");
        }
        // 循环这个链表，打印数据
        while (true){
            //如果节点下一个没有下一个节点，跳出循环
            if(temp.next == null){
                break;
            }
            // 打印当前节点信息
            System.out.println(temp.next);
            //  移动指针到下一位
            temp = temp.next;
        }
    }
}
