package com.elasticsearch.demo.service.impl.content;

import com.elasticsearch.demo.controller.dto.content.UpsertContentDocumentParam;
import com.elasticsearch.demo.controller.response.Exception.ContentException;
import com.elasticsearch.demo.service.content.UpsertContentDocumentService;
import com.elasticsearch.demo.service.util.JsonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpHost;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UpsertContentDocumentServiceImpl implements UpsertContentDocumentService {

    /** {@link} */
    @Override
    public void upsertDocument(String indexName ,UpsertContentDocumentParam param) {
        String document;

        String docId = param.getContentId();

        // ObjectからJson String生成
        try {
            document = JsonService.toJsonString(param);
        }catch (JsonProcessingException e) {
            throw new ContentException("ドキュメントの登録/更新に失敗しました。");
        }

        String endpoint = "/" + indexName + "/_doc/" + docId;

        try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200))
                .setRequestConfigCallback(requestConfigBuilder ->
                        requestConfigBuilder.setConnectTimeout(5000) // 接続タイムアウトを5秒に設定
                                .setSocketTimeout(60000)) // ソケットタイムアウトを60秒に設定
                .build()) {
            Request upsertDocumentRequest = new Request("PUT", endpoint);
            upsertDocumentRequest.setJsonEntity(document);
            Response response = restClient.performRequest(upsertDocumentRequest);

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new ContentException("索引の作成に失敗しました。");
            }

        }catch (Exception e) {
            throw new ContentException(e.getMessage());
        }
    }
}
