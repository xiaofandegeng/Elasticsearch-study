package com.atguigu.linkedlist.circle;

/**
 * @Description boy节点类
 * @Author lhw
 * @Date 2021/5/26 20:22
 * @Version 1.0
 **/
public class Boy {
    private Integer no;
    private Boy next;

    public Boy(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
