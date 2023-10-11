package com.elasticsearch.demo.service.impl.content;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.elasticsearch.demo.controller.dto.content.SearchContentDocumentParam;
import com.elasticsearch.demo.controller.response.Exception.ContentException;
import com.elasticsearch.demo.controller.response.content.SearchContentDocumentResponse;
import com.elasticsearch.demo.service.content.SearchContentDocumentService;
import com.elasticsearch.demo.service.util.ObjectToMapperConverter;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchContentDocumentServiceImpl implements SearchContentDocumentService {

    @Override
    public List<SearchContentDocumentResponse> searchDocument(String indexName, SearchContentDocumentParam param) {
        String endpoint = "/" + indexName + "/_search/";
        List<SearchContentDocumentResponse> result = new ArrayList<>();

        SearchResponse<SearchContentDocumentResponse> search  = null;

        try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200))
                .setRequestConfigCallback(requestConfigBuilder ->
                        requestConfigBuilder.setConnectTimeout(5000) // 接続タイムアウトを5秒に設定
                                .setSocketTimeout(60000)) // ソケットタイムアウトを60秒に設定
                .build()) {

            //Mapper生成
            JacksonJsonpMapper jsonpMapper = new JacksonJsonpMapper();

            // Transport生成
            ElasticsearchTransport transport = new RestClientTransport(restClient, jsonpMapper);

            // Client生成
            ElasticsearchClient client = new ElasticsearchClient(transport);


            // 検索条件ObjectからMapへ変換
            Map<String, Object> searchParamMap = ObjectToMapperConverter.convertObjectToMap(param.getCondition());

            // 検索クエリ生成

            BoolQuery.Builder boolQuery = QueryBuilders.bool();
            List<Query> queryList = new ArrayList<>();

            for (Map.Entry<String, Object> entry : searchParamMap.entrySet()) {
                if (Objects.nonNull(entry.getValue())) {
                    TermQuery termQuery = QueryBuilders.term().field(entry.getKey()).value(entry.getValue().toString()).build();
                    queryList.add(termQuery._toQuery());
                }
            }
            Query query = boolQuery.must(queryList).build()._toQuery();
            System.out.println(query);

            System.out.println("------");
             search = client.search(s -> s
                            .index(indexName)
                            .query(
                                    q -> q.matchAll(QueryBuilders.matchAll().build())
                            )


                            ,
                    SearchContentDocumentResponse.class);

        }catch (Exception e) {

            for (StackTraceElement element : e.getStackTrace()) {
                System.err.println(element);
            }
            throw new ContentException(e.getMessage());
        }

        return search.hits().hits().stream().map(
                Hit::source
        ).collect(Collectors.toList());
    }
}
