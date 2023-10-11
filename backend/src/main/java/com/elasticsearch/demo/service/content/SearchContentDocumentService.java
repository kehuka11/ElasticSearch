package com.elasticsearch.demo.service.content;

import com.elasticsearch.demo.controller.dto.content.SearchContentDocumentParam;
import com.elasticsearch.demo.controller.response.content.SearchContentDocumentResponse;

import java.util.List;

public interface SearchContentDocumentService {

    public List<SearchContentDocumentResponse> searchDocument(String indexName, SearchContentDocumentParam param);
}
