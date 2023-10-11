package com.elasticsearch.demo.controller.dto.content;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UpsertContentDocumentParam {
    /** コンテンツID **/
    private String content_id;

    /** コンテンツ名 */
    private String content_name;

    /** コンテンツ説明 */
    private String content_explanation;

    /** 公開開始日 */
    private String publish_start_date;

    /** 公開終了日 */
    private String publish_end_date;
}
