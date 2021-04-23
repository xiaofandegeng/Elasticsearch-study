package com.atguigu.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * Demo es客户端向文档批量插入数据
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClientDocDeleteBatch {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));

        //批量向文档插入数据
        BulkRequest request = new BulkRequest();

        DeleteRequest indexRequest1 = new DeleteRequest().index("test").id("1010");
        DeleteRequest indexRequest2 = new DeleteRequest().index("test").id("1011");
        DeleteRequest indexRequest3 = new DeleteRequest().index("test").id("1012");

        request.add(indexRequest1).add(indexRequest2).add(indexRequest3);

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());


        //关闭客户端
        client.close();
    }
}
