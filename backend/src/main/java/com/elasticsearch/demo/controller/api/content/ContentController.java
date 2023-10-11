package com.elasticsearch.demo.controller.api.content;

import com.elasticsearch.demo.controller.dto.content.CreateContentIndexParam;
import com.elasticsearch.demo.controller.dto.content.DeleteContentDocumentParam;
import com.elasticsearch.demo.controller.dto.content.SearchContentDocumentParam;
import com.elasticsearch.demo.controller.dto.content.UpsertContentDocumentParam;
import com.elasticsearch.demo.controller.request.content.CreateContentIndexRequest;
import com.elasticsearch.demo.controller.request.content.DeleteContentDocumentRequest;
import com.elasticsearch.demo.controller.request.content.SearchContentDocumentRequest;
import com.elasticsearch.demo.controller.request.content.UpsertContentDocumentRequest;
import com.elasticsearch.demo.controller.response.EmptyResponse;
import com.elasticsearch.demo.controller.response.content.SearchContentDocumentResponse;
import com.elasticsearch.demo.service.content.CreateContentIndexService;
import com.elasticsearch.demo.service.content.DeleteContentDocumentService;
import com.elasticsearch.demo.service.content.SearchContentDocumentService;
import com.elasticsearch.demo.service.content.UpsertContentDocumentService;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ContentController {

    @Autowired private CreateContentIndexService createContentIndexService;

    @Autowired private UpsertContentDocumentService upsertContentDocumentService;

    @Autowired private DeleteContentDocumentService deleteContentDocumentService;

    @Autowired private SearchContentDocumentService searchContentDocumentService;

    @PostMapping("/content/index/create")
    public ResponseEntity<EmptyResponse> createContentIndex(@RequestBody CreateContentIndexRequest request) {

        CreateContentIndexParam param = CreateContentIndexParam.builder()
                .publishEndDate(request.getPublishEndDate())
                .build();

        createContentIndexService.createContentIndex(param);

        return ResponseEntity.ok(new EmptyResponse());

    }

    @PutMapping("/content/document/upsert")
    public ResponseEntity<EmptyResponse> upsertDocument(@RequestBody UpsertContentDocumentRequest request) {

        UpsertContentDocumentParam param = UpsertContentDocumentParam.builder()
                .content_id(request.getContentId())
                .content_name(request.getContentName())
                .content_explanation(request.getContentExplanation())
                .publish_start_date(request.getPublishStartDate())
                .publish_end_date(request.getPublishEndDate())
                .build();

        upsertContentDocumentService.upsertDocument(request.getIndexName(), param);

        return ResponseEntity.ok(new EmptyResponse());
    }

    @DeleteMapping("/content/document/delete")
    public ResponseEntity<EmptyResponse> deleteDocument(@RequestBody DeleteContentDocumentRequest request) {

        DeleteContentDocumentParam param = DeleteContentDocumentParam.builder()
                .indexName(request.getIndexName())
                .documentId(request.getDocumentId())
                .build();

        deleteContentDocumentService.deleteDocument(param);

        return ResponseEntity.ok(new EmptyResponse());
    }

    @GetMapping("/content/document/get")
    public ResponseEntity<List<SearchContentDocumentResponse>> searchDocument(@ModelAttribute SearchContentDocumentRequest request) {

        final String DEFAULT_SIZE = "10";
        final String DEFAULT_SORT = "0"; // 昇順

        SearchContentDocumentParam param = SearchContentDocumentParam.builder()
                .size(Objects.nonNull(request.getSize()) ? Integer.parseInt(request.getSize()) : Integer.parseInt(DEFAULT_SIZE))
                .sort(Objects.nonNull(request.getSort()) ? Integer.parseInt(request.getSort()) : Integer.parseInt(DEFAULT_SORT))
                .condition(SearchContentDocumentParam.Condition.builder()
                        .contentName(Objects.nonNull(request.getContent_name()) ? request.getContent_name() : null)
                        .publishStartDate(Objects.nonNull(request.getPublish_start_date()) ? request.getPublish_start_date() : null)
                        .publishEndDate(Objects.nonNull(request.getPublish_end_date()) ? request.getPublish_end_date() : null)
                        .build())
                .build();

        List<SearchContentDocumentResponse> result = searchContentDocumentService.searchDocument(request.getIndex_name(), param);

        return ResponseEntity.ok(result );

    }
}
