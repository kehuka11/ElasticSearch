package com.elasticsearch.demo.service.impl.content;

import com.elasticsearch.demo.controller.dto.content.CreateContentIndexParam;
import com.elasticsearch.demo.controller.response.Exception.ContentException;
import com.elasticsearch.demo.service.content.CreateContentIndexService;
import org.apache.http.HttpHost;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreateContentIndexServiceImpl implements CreateContentIndexService {


    private final String INDEX_PREFIX = "content_";

    /** {@linkplain } */
    @Override
    public void createContentIndex(CreateContentIndexParam param) {

        final String indexName = INDEX_PREFIX.concat(param.getPublishEndDate().toString());


        try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200))
                .setRequestConfigCallback(requestConfigBuilder ->
                        requestConfigBuilder.setConnectTimeout(5000) // 接続タイムアウトを5秒に設定
                                .setSocketTimeout(60000)) // ソケットタイムアウトを60秒に設定
                .build()) {
           Request createIndexRequest = new Request("PUT", indexName);
            Response response = restClient.performRequest(createIndexRequest);

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new ContentException("索引の作成に失敗しました。");
            }

        }catch (IOException e) {
            throw new ContentException("索引の作成に失敗しました。");
        }

    }
}
