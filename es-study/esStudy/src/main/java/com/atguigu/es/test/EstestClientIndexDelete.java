package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * Demo es客户端删除索引的方法
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClientIndexDelete {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http")));

        //删除索引
        DeleteIndexRequest request = new DeleteIndexRequest("test");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);

        //判断创建索引操作是否成功
        System.out.println("删除索引操作：" + response.isAcknowledged());

        //关闭客户端
        client.close();
    }
}
