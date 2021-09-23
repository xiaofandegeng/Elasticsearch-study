package com.atguigu.case2;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description 分布式锁测试类
 * @Author lhw
 * @Date 2021/9/23 11:51
 * @Version 1.0
 **/
public class DistributeLockTest {
    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        DistributeLock lock1 = new DistributeLock();
        DistributeLock lock2 = new DistributeLock();

        new Thread(() -> {

            try {
                lock1.zkLock();
                System.out.println("线程1 启动，获取到锁");
                TimeUnit.SECONDS.sleep(5);
                lock1.unZkLock();
                System.out.println("线程1 释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {

            try {
                lock2.zkLock();
                System.out.println("线程2 启动，获取到锁");
                TimeUnit.SECONDS.sleep(5);
                lock2.unZkLock();
                System.out.println("线程2 释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
