package com.atguigu.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * Demo es客户端向文档插入数据
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClientDocInsert {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));

        //创建索引
        IndexRequest request = new IndexRequest();
        request.index("test").id("1005");

        UserInfo info3 = new UserInfo("阿七", "男", 28);

        //向es里面插入数据必须转为json格式
        ObjectMapper mapper = new ObjectMapper();
        String user3 = mapper.writeValueAsString(info3);


        request.source(user3, XContentType.JSON);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        //查看返回结果
        System.out.println("查询索引操作：" + response.getResult());

        //关闭客户端
        client.close();
    }
}
