package com.elasticsearch.demo.controller.response.content;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchContentDocumentResponse {

    /** コンテンツID */
    private String contentId;

    /** コンテンツ名 */
    private String contentName;

    /** コンテンツ説明 */
    private String contentExplanation;


    /** 公開開始日付 */
    private String publishStartDate;

    /** 公開終了日付 */
    private String publishEndDate;

}
