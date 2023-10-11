package com.elasticsearch.demo.service.impl.content;

import com.elasticsearch.demo.controller.dto.content.DeleteContentDocumentParam;
import com.elasticsearch.demo.controller.response.Exception.ContentException;
import com.elasticsearch.demo.service.content.DeleteContentDocumentService;
import org.apache.http.HttpHost;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

@Service
public class DeleteContentDocumentServiceImpl implements DeleteContentDocumentService {

    @Override
    public void deleteDocument(DeleteContentDocumentParam param) {
        String indexName = param.getIndexName();
        String documentId = param.getDocumentId();

        String endpoint = "/" + indexName + "/_doc/" + documentId;

        try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200))
                .setRequestConfigCallback(requestConfigBuilder ->
                        requestConfigBuilder.setConnectTimeout(5000) // 接続タイムアウトを5秒に設定
                                .setSocketTimeout(60000)) // ソケットタイムアウトを60秒に設定
                .build()) {
            Request upsertDocumentRequest = new Request("DELETE", endpoint);

            Response response = restClient.performRequest(upsertDocumentRequest);

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new ContentException("索引の作成に失敗しました。");
            }

        }catch (Exception e) {
            throw new ContentException(e.getMessage());
        }
    }
}
