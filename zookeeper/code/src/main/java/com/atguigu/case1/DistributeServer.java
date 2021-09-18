package com.atguigu.case1;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description 分发服务器
 * @Author lhw
 * @Date 2021/9/18 15:22
 * @Version 1.0
 **/
public class DistributeServer {
    String connectString = "hadoop101:2181,hadoop102:2181,hadoop103:2181";
    int sessionTimeOut = 2000;
    ZooKeeper zk;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer server = new DistributeServer();

        // 1.获取zk连接
        server.getConnect();
        // 2.注册服务器到zk集群
        server.register(args[0]);
        // 3.启动业务逻辑
        server.business();
    }

    private void business() throws InterruptedException {
        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }

    private void register(String hostName) throws KeeperException, InterruptedException {
        zk.create("/servers/" + hostName, hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("hostName: " + hostName + " is onLine");
    }

    private void getConnect() throws IOException {

        zk = new ZooKeeper(connectString, sessionTimeOut, watchedEvent -> {

        });
    }
}
