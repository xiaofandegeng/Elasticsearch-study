package com.atguigu.queue;

public class QueueArray {
    private int maxSize;  // 队列的最大容量
    private int front;  // 队列的前一个数据
    private int rear;  // 队列的最后一个数据就是队尾数据
    private int[] arr;  // 队列

    // 初始化一个队列
    public QueueArray(int arrMaxSize){
        this.maxSize = arrMaxSize;
        this.arr = new int[arrMaxSize];
        this.front = 0;
        this.rear = 0;
    }

    // 判断一个队列是否为空
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    // 判断一个队列是否满数据
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 往一个队列添加数据
    public void addQueue(int num) {
        if(isFull()){
            System.out.println("队列已满，不能添加数据~~~");
            return;
        }
        arr[rear] = num;
        rear = (rear+1) % maxSize;
        System.out.println("当前的rear为：" + rear);
    }
    //往一个队列取出数据
    public int getQueue() {
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取出数据~~~");
        }
        int tmp = arr[front];
        front = (front + 1) % maxSize;
        System.out.println("当前的front为：" + front);
        return tmp;
    }
    //显示队列所有的数据
    public void showQueue() {
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能显示所有数据~~~");
        }
        for (int i = front; i < front + size(); i++) {
            int res = i % maxSize;
            System.out.printf("arr[%d]=%d\t", res, arr[res]);
        }
    }

    // 显示队列有效个数
    public int size() {
        return (rear + maxSize -front) % maxSize;
    }

    // 显示队列头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能显示头数据~~~");
        }
        return arr[front];
    }
}
