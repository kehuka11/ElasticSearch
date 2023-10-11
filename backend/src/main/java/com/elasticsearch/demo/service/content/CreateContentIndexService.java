package com.elasticsearch.demo.service.content;

import com.elasticsearch.demo.controller.dto.content.CreateContentIndexParam;

public interface CreateContentIndexService {

    /**
     * コンテンツ索引作成
     * @param param コンテンツ索引作成用パラメータ
     */
    public void createContentIndex(CreateContentIndexParam param);
}
