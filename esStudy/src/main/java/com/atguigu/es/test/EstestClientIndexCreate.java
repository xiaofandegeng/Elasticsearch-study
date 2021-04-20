package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * Demo es客户端创建索引的方法
 *
 * @author liaohongwei
 * @date 2021/04/20
 */

public class EstestClientIndexCreate {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http")));

        //创建索引
        CreateIndexRequest request = new CreateIndexRequest("test");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);

        //判断创建索引操作是否成功
        System.out.println("创建索引操作：" + response.isAcknowledged());

        //关闭客户端
        client.close();
    }
}
