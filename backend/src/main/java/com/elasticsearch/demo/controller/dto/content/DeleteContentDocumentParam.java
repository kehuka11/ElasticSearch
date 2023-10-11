package com.elasticsearch.demo.controller.dto.content;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class DeleteContentDocumentParam {

    /** インデックス名 */
    private String indexName;

    /** ドキュメントID */
    private String documentId;
}
