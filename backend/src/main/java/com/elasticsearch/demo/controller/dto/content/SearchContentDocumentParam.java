package com.elasticsearch.demo.controller.dto.content;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
public class SearchContentDocumentParam {

    /** 取得件数 */
    private Integer size;

    /** ソート順（0:昇順、1:降順） */
    private Integer sort;

    private Condition condition;


    @Data
    @Builder
    public static class Condition {
        /** コンテンツ名(検索条件) */
        private String contentName;

        /** 公開開始日(検索条件) */
        private String publishStartDate;

        /** 公開終了日(検索条件) */
        private String publishEndDate;
    }
}
