package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * Demo es客户端查询所有索引的方法
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClientIndexSelect {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));

        //创建索引
        GetIndexRequest request = new GetIndexRequest("test");
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);

        //判断创建索引操作是否成功
        System.out.println("查询索引操作：" + response.getAliases());
        System.out.println("查询索引操作：" + response.getIndices());
        System.out.println("查询索引操作：" + response.getSettings());
        System.out.println("查询索引操作：" + response.getMappings());

        //关闭客户端
        client.close();
    }
}
