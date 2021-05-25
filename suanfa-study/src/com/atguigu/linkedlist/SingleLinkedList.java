package com.atguigu.linkedlist;

import javax.print.DocFlavor;
import javax.sound.midi.Soundbank;
import java.util.Stack;

/**
 * 定义一个类 管理英雄节点
 */
public class SingleLinkedList {

    public HeroNode getHeadNode() {
        return headNode;
    }

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

    //更新英雄节点数据
    public void update(HeroNode newHeroNode){
        //如果链表为空直接返回
        if(headNode.next == null){
            System.out.println("~~~~~~当前链表为空~~~~~~");
            return;
        }
        //定义一个指针
        HeroNode temp = headNode.next;
        //定义一个条件，判断是否找到该节点，默认该节点不存在
        Boolean flag = false;
        //循环链表找该节点是否存在
        while (true){
            //判断是否找到了链表末尾
            if(temp == null){
                break;
            }
            // 找到了该节点的编号
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            //后移指针节点
            temp = temp.next;
        }
        //如果找到该节点，更新数据
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("修改英雄节点编号：%d 不存在，无法修改\n", newHeroNode.no);
        }
    }

    //删除某一个节点
    public void del(int  no){
        //如果链表为空不能删除
        if(headNode.next == null) {
            System.out.println("~~~~~~当前链表为空，不能删除节点~~~~~~");
            return;
        }
        //定义一个节点，该节点为删除节点的前一个节点
        HeroNode temp = headNode;
        //定义一个判断条件，找到删除节点是否存在，默认不存在
        boolean flag = false;
        //循环链表找这个节点
        while (true){
            //找到链表末尾还是没有找到这个节点，说明这个节点不存在，跳出循环
            if(temp.next == null){
                break;
            }
            //如果当前节点的no等于删除节点no，说明找到了这个节点
            if(temp.next.no == no){
                flag = true;
                break;
            }
            //后移这个节点
            temp = temp.next;
        }
        //判断这个节点是否存在,存在则删除这个节点
        if(flag){
            temp.next = temp.next.next;
        } else {
            System.out.printf("~~~~~~删除节点的编号为：%d，不存在该节点\n", no);
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

    //  1.求单链表中有效节点的个数
    public Integer getLength() {
        int count = 0;
        HeroNode temp = headNode;
        if(temp.next == null){
            System.out.println("~~~~~~当前链表为空~~~~~~");
            return count;
        }
        // 循环这个链表，打印数据
        while (true){
            //如果节点下一个没有下一个节点，跳出循环
            if(temp.next == null){
                break;
            }
            //当前链表的个数+1
            count++;
            //  移动指针到下一位
            temp = temp.next;
        }
        return count;
    }

    //  2.查找单链表中的倒数第k个结点 【新浪面试题】
    public HeroNode getDescNum(int descNum) {
        Integer count = getLength();
        if(count == 0 || count < descNum || descNum <= 0){
            System.out.println("当前链表个数为空或者小于你查询数量的个数！");
            return null;
        }

        int index = count - descNum;
        HeroNode cur = headNode.next;
        //  定义一个判断条件表示找到这个节点的位置了
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //  3.单链表的反转【腾讯面试题，有点难度】
    public void reverseNode(HeroNode headNode) {
        //  如果当前单链表为空 或则 只有一个节点 不用反转
        if(headNode.next == null || headNode.next.next ==null){
            System.out.println("当前链表为空或则链表个数为1，不用反转");
            return;
        }
        //
        HeroNode cur = headNode.next;
        HeroNode next = null;
        HeroNode tmp = new HeroNode(0, null, null);
        while (cur != null){
            //  将下一个节点暂时保存起来
            next = cur.next;
            cur.next = tmp.next;
            tmp.next = cur;
            //  移动当前节点
            cur = next;
        }
        //头节点指向最后一个节点
        headNode.next = tmp.next;
    }

    //  4.从尾到头打印单链表 【百度，要求方式1：反向遍历 。 方式2：Stack栈】
    public void reversePrintNode(HeroNode headNode){
        // 判断当前链表是否为空
        if(headNode.next == null) {
            System.out.println("当前链表为空，无法从尾到头打印数据！");
            return;
        }
        //  记录当前节点
        HeroNode cur = headNode.next;
        Stack<HeroNode> stack = new Stack<>();
        //  循环链表
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        System.out.println("stack的大小为：" + stack.size());
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }



    }

}
