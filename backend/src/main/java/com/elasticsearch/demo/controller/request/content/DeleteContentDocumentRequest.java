package com.elasticsearch.demo.controller.request.content;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DeleteContentDocumentRequest {

    /** インデックス名 */
    @NotEmpty
    private String indexName;

    /** ドキュメントID */
    @NotEmpty
    private String documentId;
}
