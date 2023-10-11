package com.elasticsearch.demo.controller.request.content;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SearchContentDocumentRequest {
    /** クエリパラメータはスネークケースでないとマッピングできない。。 */

    /** インデックス名 */
    @NotEmpty
    private String index_name;

    /** 取得件数 */
    @NumberFormat
    @Size(min = 1, max = 100)
    private String size;

    /** ソート順（0:昇順、1:降順） */
    @Size(min = 0, max = 1)
    private String sort;

    /** コンテンツ名(検索条件) */
    private String content_name;

    /** 公開開始日(検索条件) */
    private String publish_start_date;

    /** 公開終了日(検索条件) */
    private String publish_end_date;
}
