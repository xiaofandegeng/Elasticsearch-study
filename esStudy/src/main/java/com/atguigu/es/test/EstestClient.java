package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * Demo es客户端创建的方法
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClient {
    public static void main(String[] args) throws IOException {

            //创建es客户端
            RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));

            //关闭客户端
            client.close();
    }
}
