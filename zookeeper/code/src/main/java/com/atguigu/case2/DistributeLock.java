package com.atguigu.case2;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description 分布式锁
 * @Author lhw
 * @Date 2021/9/23 11:16
 * @Version 1.0
 **/
public class DistributeLock {
    private final String connectString = "hadoop101:2181,hadoop102:2181,hadoop103:2181";
    private final int sessionTimeOut = 2000;
    private final ZooKeeper zk;
    private String waitPath;

    CountDownLatch countDownLatch = new CountDownLatch(1);
    CountDownLatch waitLatch = new CountDownLatch(1);
    private String curMode;

    public DistributeLock() throws IOException, InterruptedException, KeeperException {
        // 获取连接
        zk = new ZooKeeper(connectString, sessionTimeOut, watchedEvent -> {
            if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                countDownLatch.countDown();
            }

            if (watchedEvent.getType() == Watcher.Event.EventType.NodeDeleted
                    && watchedEvent.getPath().equals(waitPath)) {
                waitLatch.countDown();
            }


        });
        // 等待
        countDownLatch.await();
        // 判断根节点/locks是否存在
        Stat exists = zk.exists("/locks", false);
        if (exists == null) {
            zk.create("/locks", "locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    // 加锁方法
    public void zkLock() {
        // 创建对应的临时带序号的节点
        try {
            curMode = zk.create("/locks/" + "seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            // 判断创建节点是否是最小的序号节点，如果是获取到锁，如果不是，监听他序号的前一个节点
            List<String> children = zk.getChildren("/locks", false);
            if (children.size() == 1) {
                return;
            } else {
                Collections.sort(children);
                String thisNode = curMode.substring("/locks/".length());
                int index = children.indexOf(thisNode);

                if (index == -1) {
                    System.out.println("数据异常");
                } else if (index == 0) {
                    return;
                } else {
                    waitPath = "/locks/" + children.get(index - 1);
                    zk.getData(waitPath, true, null);

                    waitLatch.await();
                    return;
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // 解锁方法
    public void unZkLock() {
        // 删除节点
        try {
            zk.delete(curMode, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
