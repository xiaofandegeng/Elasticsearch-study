package com.atguigu.linkedlist.circle;

/**
 * @Description 环形链表
 * @Author lhw
 * @Date 2021/5/26 20:35
 * @Version 1.0
 **/
public class CircleLinkedList {
    //  定义第一个节点信息
    private Boy first = null;

    /**
     * 添加孩子节点
     *
     * @param nums 添加孩子数量
     */
    public void addBoy(int nums) {
        //  判断添加孩子数是否小于1
        if (nums < 1) {
            System.out.printf("~~~~~~添加数量为：%d，添加失败~~~~~~", nums);
        }
        //  辅助指针，用于构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            //  新增进来的boy
            Boy boy = new Boy(i);
            //  如果只有一个节点，则该节点会跟自己构成环状
            if (i == 1) {
                first = boy;
                curBoy = boy;
                boy.setNext(curBoy);
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 小孩循环出圈
     *
     * @param startNum 开始位置
     * @param size     每次数数 数大小
     * @param nums     总数量
     */
    public void countBoy(int startNum, int size, int nums) {
        //  先判断是否有效
        if (startNum < 0 || size < 0 || nums < 0 || nums - size < 0) {
            System.out.println("~~~~~~输入有误，请重试！~~~~~~");
        }
        //  打印一个辅助变量last，指向first的后面
        Boy last = first;
        while (true) {
            if (last.getNext() == first) {
                break;
            }
            last = last.getNext();
        }
        //  从startNum开始数数，移动first和last
        for (int i = 0; i < startNum - 1; i++) {
            first = first.getNext();
            last = last.getNext();
        }
        //  开始循环这个链表打印
        while (true) {
            //  只有一个节点，结束循环
            if(first == last) {
                break;
            }
            //  移动first和last，找到移除节点数
            for (int i = 0; i < size - 1; i++) {
                first = first.getNext();
                last = last.getNext();
            }
            System.out.println("移除的节点编号为：" + first.getNo());

            //  将找到的节点移出去
            first = first.getNext();
            last.setNext(first);
        }
        System.out.println("最后一个节点编号为：" + first.getNo());
    }

    /**
     * 循环打印这个链表
     */
    public void showBoy() {
        //  判断环形链表是否为空
        if (first.getNext() == first) {
            System.out.println("~~~~~~当前链表为空，无法显示~~~~~~");
            return;
        }
        //  循环打印这个链表
        Boy curBoy = first;
        while (true) {
            //  打印一个辅助变量
            //  找到了链表尾部
            System.out.println("当前节点编号为：" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

}
