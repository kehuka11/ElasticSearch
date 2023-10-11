package com.elasticsearch.demo.service.content;

import com.elasticsearch.demo.controller.dto.content.UpsertContentDocumentParam;

public interface UpsertContentDocumentService {

    public void upsertDocument(String indexName ,UpsertContentDocumentParam param);
}
