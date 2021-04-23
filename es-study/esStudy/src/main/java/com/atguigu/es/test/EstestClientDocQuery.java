package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * Demo es客户端向文档查询数据
 *
 * @author liaohongwei
 * @date 2021/04/20
 */
public class EstestClientDocQuery {
    public static void main(String[] args) throws IOException {
        //创建es客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));

        // 查询索引中的全部数据
        //queryMatchAll(client);

        // 条件查询
        //queryByTerm(client);

        //分页查询
        //queryPage(client);

        // 查询排序
        //queryOrder(client);

        // 过滤字段
        //queryFetch(client);

        // 组合查询
        //queryBoolQuery(client);

        //范围查询
        //queryRange(client);

        //模糊查询
        //queryFuzzy(client);

        // 高亮查询
        //queryHighlight(client);

        // 聚合查询:最大值查询
        //queryMax(client);


        //关闭客户端
        client.close();
    }

    private static void queryMax(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        //最大值查询条件
        MaxAggregationBuilder maxAggregationBuilder = AggregationBuilders.max("maxAge").field("age");
        builder.aggregation(maxAggregationBuilder);

        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryHighlight(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        //高亮查询条件
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "李");
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='res'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name");

        builder.highlighter(highlightBuilder);
        builder.query(termQueryBuilder);


        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryFuzzy(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        //模糊查询条件
        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "李六").fuzziness(Fuzziness.ONE);

        builder.query(fuzzyQueryBuilder);
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryRange(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());

        //范围查询条件
        RangeQueryBuilder queryBuilder = QueryBuilders.rangeQuery("age");
        queryBuilder.gte(25);
        queryBuilder.lte(50);

        builder.query(queryBuilder);
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryBoolQuery(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());

        //组合查询条件
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        queryBuilder.must(QueryBuilders.matchQuery("age", 28));
        queryBuilder.must(QueryBuilders.matchQuery("sex", "男"));
        builder.query(queryBuilder);

        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryFetch(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());

        String[] in = {};
        String[] out = {"name"};
        builder.fetchSource(in, out);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryOrder(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.sort("age", SortOrder.DESC);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryPage(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.from(0);
        builder.size(3);
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryByTerm(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("test");
        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",28)));

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    private static void queryMatchAll(RestHighLevelClient client) throws IOException {
        //查询索引中的全部数据
        SearchRequest request = new SearchRequest();
        request.indices("test");
        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit: hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
}
