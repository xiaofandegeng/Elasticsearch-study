package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * Demo es客户端向文档删除数据
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClientDocDelete {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));

        //删除文档的值
        DeleteRequest request = new DeleteRequest();
        request.index("test").id("1005");

        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);

        //查看返回结果
        System.out.println("查询索引操作：" + response.getResult());

        //关闭客户端
        client.close();
    }
}
