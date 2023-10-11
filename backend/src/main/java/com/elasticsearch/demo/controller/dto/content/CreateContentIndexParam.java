package com.elasticsearch.demo.controller.dto.content;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreateContentIndexParam {


    /** 公開終了日 */
    private LocalDate publishEndDate;
}
