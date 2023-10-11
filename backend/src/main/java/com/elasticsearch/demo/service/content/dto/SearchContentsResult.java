package com.elasticsearch.demo.service.content.dto;

import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import lombok.Builder;
import lombok.Data;
import org.elasticsearch.client.eql.EqlSearchResponse;

@Data
@Builder
public class SearchContentsResult {


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

