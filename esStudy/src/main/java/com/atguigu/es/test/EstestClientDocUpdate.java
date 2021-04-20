package com.atguigu.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * Demo es客户端向文档修改数据
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClientDocUpdate {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));

        //修改文档的值
        UpdateRequest request = new UpdateRequest();
        request.index("test").id("1005");
        request.doc(XContentType.JSON,"name","大小王");

        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);

        //查看返回结果
        System.out.println("查询索引操作：" + response.getResult());

        //关闭客户端
        client.close();
    }
}
