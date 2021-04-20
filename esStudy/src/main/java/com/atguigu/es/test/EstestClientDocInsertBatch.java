package com.atguigu.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
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
public class EstestClientDocInsertBatch {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));

        //批量向文档插入数据
        BulkRequest request = new BulkRequest();

        IndexRequest indexRequest1 = new IndexRequest().index("test").id("1010");
        IndexRequest indexRequest2 = new IndexRequest().index("test").id("1011");
        IndexRequest indexRequest3 = new IndexRequest().index("test").id("1012");
        //向es里面插入数据必须转为json格式
        ObjectMapper mapper = new ObjectMapper();
        indexRequest1.source(mapper.writeValueAsString(new UserInfo("小11", "男", 21)), XContentType.JSON);
        indexRequest2.source(mapper.writeValueAsString(new UserInfo("小22", "女", 51)), XContentType.JSON);
        indexRequest3.source(mapper.writeValueAsString(new UserInfo("小33", "男", 11)), XContentType.JSON);

        request.add(indexRequest1).add(indexRequest2).add(indexRequest3);

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());


        //关闭客户端
        client.close();
    }
}
