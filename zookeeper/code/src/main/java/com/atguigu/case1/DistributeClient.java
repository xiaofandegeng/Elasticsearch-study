package com.atguigu.case1;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description 分发客户端
 * @Author lhw
 * @Date 2021/9/18 15:22
 * @Version 1.0
 **/
public class DistributeClient {
    String connectString = "hadoop101:2181,hadoop102:2181,hadoop103:2181";
    int sessionTimeOut = 2000;
    ZooKeeper zk;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeClient server = new DistributeClient();

        // 1.获取zk连接
        server.getConnect();
        // 2.监听servers下面子节点的增加和删除
        server.getServiceList();
        // 3.启动业务逻辑
        server.business();
    }

    private void getServiceList() throws KeeperException, InterruptedException {
        List<String> children = zk.getChildren("/servers", true);
        ArrayList<String> servers = new ArrayList<>();
        for (String child : children) {
            byte[] data = zk.getData("/servers/" + child, false, null);
            servers.add(new String(data));

        }
        System.out.println("servers: " + servers);
    }


    private void business() throws InterruptedException {
        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }


    private void getConnect() throws IOException {

        zk = new ZooKeeper(connectString, sessionTimeOut, watchedEvent -> {
            try {
                getServiceList();
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
