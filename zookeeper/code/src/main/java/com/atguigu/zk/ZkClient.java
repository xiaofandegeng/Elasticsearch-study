package com.atguigu.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Description zk客户端
 * @Author lhw
 * @Date 2021/9/18 14:06
 * @Version 1.0
 **/
public class ZkClient {

    private final String connectString = "hadoop102:2181,hadoop103:2181,hadoop101:2181";

    private final int sessionTimeout = 2000;

    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                // 收到消息的回调函数
                System.out.println(watchedEvent.getType() + "--" + watchedEvent.getPath());

                try {
                    List<String> children = zkClient.getChildren("/", true);
                    for (String child : children) {
                        System.out.println("child: " + child);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (KeeperException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String nodeCreated = zkClient.create("/atGuiGu2", "atGuiGu2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    }

    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);
        for (String child : children) {
            System.out.println("child: " + child);
        }
    }

    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat exists = zkClient.exists("/atGuiGu", false);
        System.out.println(exists == null ? "not exists" : "exists");
    }
}
