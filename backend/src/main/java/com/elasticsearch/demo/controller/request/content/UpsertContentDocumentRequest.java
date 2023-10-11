package com.elasticsearch.demo.controller.request.content;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class UpsertContentDocumentRequest {

    /** インデックス名 */
    @NotEmpty
    private String indexName;

    /** コンテンツID **/
    @NotEmpty
    private String contentId;

    /** コンテンツ名 */
    @NotEmpty
    private String contentName;

    /** コンテンツ説明 */
    @NotEmpty
    private String contentExplanation;

    /** 公開開始日 */
    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String publishStartDate;

    /** 公開終了日 */
    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String publishEndDate;
}
