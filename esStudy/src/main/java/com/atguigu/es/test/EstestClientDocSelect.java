package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * Demo es客户端向文档查询数据
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClientDocSelect {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));

        //修改文档的值
        GetRequest request = new GetRequest();
        request.index("test").id("1005");

        GetResponse response = client.get(request, RequestOptions.DEFAULT);

        //查看返回结果
        System.out.println("查询索引操作：" + response.getSourceAsString());

        //关闭客户端
        client.close();
    }
}
